package AoC_2025.day06.a;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class Parser {
    private final String operators;
    private final List<Integer> numbers;
    public static Parser of(String sum) {
        return new Parser(numbers(sum), operators(sum));
    }

    private static String operators(String sum) {
        return sum.chars().filter(s -> s == '+' || s == '*')
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    private static List<Integer> numbers(String sum) {
        return Arrays.stream(sum.split("\\s")).
                takeWhile(s -> !(s.contains("+") || s.contains("*")))
                .map(Parser::toInt)
                .flatMap(Optional::stream).toList();
    }

    private static Optional<Integer> toInt(String s) {
        if (s.isBlank()) return Optional.empty();
        return Optional.of(Integer.parseInt(s));
    }

    private Parser(List<Integer> numbers, String operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public long operate() {

        return IntStream.range(0, operators.length())
                .mapToLong(this::calculateColumn)
                .peek(System.out::println)
                .sum();
    }

    private long calculateColumn(int colIndex) {
        return operators.charAt(colIndex) == '+'
                ? columnValues(colIndex).sum()
                : columnValues(colIndex).reduce(1, (a, b) -> a * b);
    }

    private LongStream columnValues(int colIndex) {
        return IntStream.iterate(colIndex, i -> i < numbers.size(), i -> i + operators.length())
                .mapToLong(numbers::get);
    }

}
