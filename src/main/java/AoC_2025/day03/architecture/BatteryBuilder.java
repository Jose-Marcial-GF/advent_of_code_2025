package AoC_2025.day03.architecture;

import AoC_2025.Solver;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public record BatteryBuilder(Stream<String> voltages, int targetLength) implements Solver.SolverB, Solver.SolverA {

    public static BatteryBuilder with(Stream<String> input){
        return new BatteryBuilder(input, 0);
    }

    private BatteryBuilder lookingFor(int length) {
        return new BatteryBuilder(voltages, length);
    }

    private LongStream from() {
        return voltages.map(this::createBattery)
                .mapToLong(Battery::value);
    }

    private Battery createBattery(String voltageLine) {
        return new Battery(voltageLine, targetLength);
    }

    @Override
    public long solveA() {
        return lookingFor(2).from().sum();
    }

    @Override
    public long solveB() {
        return lookingFor(12).from().sum();
    }

    record Battery(String source, int length) {

        public long value() {
            return Long.parseLong(findMaxSequence());
        }

        private String findMaxSequence() {
            return IntStream.range(0, length)
                    .boxed()
                    .reduce(
                            SearchState.start(),
                            (state, digitPosition) -> state.nextDigit(source, length - 1 - digitPosition), // Acumulador
                            (oldState, newState) -> newState
                    )
                    .result();
        }
    }

    record SearchState(int currentIndex, String result) {

        static SearchState start() {
            return new SearchState(0, "");
        }

        private SearchState nextDigit(String source, int remainingDigitsNeeded) {

            return new SearchState(newIndex(source, remainingDigitsNeeded), result + getMaxDigit(source, remainingDigitsNeeded));
        }

        private int newIndex(String source, int remainingDigitsNeeded) {
            return currentIndex + getIndexOfMaxDigit(source, remainingDigitsNeeded) + 1;
        }

        private int getIndexOfMaxDigit(String source, int remainingDigitsNeeded) {
            return searchWindow(source, remainingDigitsNeeded).indexOf(getMaxDigit(source, remainingDigitsNeeded));
        }

        private char getMaxDigit(String source, int remainingDigitsNeeded) {
            return findMaxChar(searchWindow(source, remainingDigitsNeeded));
        }

        private String searchWindow(String source, int remainingDigitsNeeded) {
            return source.substring(currentIndex, source.length() - remainingDigitsNeeded);
        }

        private char findMaxChar(String window) {
            return (char) window.chars()
                    .max()
                    .orElse('0');
        }
    }
}