package AoC_2025.day05.architecture;

import AoC_2025.Solver;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record InventorySystem(String input) implements Solver.SolverA, Solver.SolverB{

    public static long freshIngredients(String input) {
        String[] sections = input.split("\n\n");

        return countFreshIngredients(sections[1].lines(), new RangeList(listOfRanges(sections[0].lines())).reduces());
    }

    private static long countFreshIngredients(Stream<String> ingredientId, RangeList rangeList) {
        return ingredientId
                .map(Long::parseLong)
                .filter(rangeList::contains)
                .count();
    }

    private static List<Range> listOfRanges(Stream<String> ranges) {
        return ranges
                .map(InventorySystem::toRange)
                .sorted(Comparator.comparingLong(Range::from))
                .toList();
    }

    public static InventorySystem with(Stream<String> input) {
        return new InventorySystem(input.collect(Collectors.joining("\n")));
    }
    public static long numbersAvailable(String  input) {
        String[] sections = input.split("\n\n");

        return new RangeList(listOfRanges(sections)).reduces().numbersAvailable();
    }

    private static List<Range> listOfRanges(String[] sections) {
        return sections[0].lines().map(InventorySystem::toRange).sorted(Comparator.comparingLong(Range::from)).toList();
    }

    private static Range toRange(String s) {
        return toRange(s.split("-"));
    }

    private static Range toRange(String[] split) {
        return new Range(toLong(split[0]), toLong(split[1]));
    }

    private static Long toLong(String s) {
        return Long.parseLong(s);
    }

    @Override
    public long solveA() {
        return freshIngredients(input);
    }

    @Override
    public long solveB() {
        return numbersAvailable(input);
    }
}

