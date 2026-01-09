package AoC_2025.day06.b;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class Parser {
    private final String operators;
    private final List<Long> numbers;
    private List<Integer> bounds;

    public static Parser of(String input) {

        List<Long> numbers = listToInt(numbers(input));
        List<String> lines = numbers(input);
        String operators = operators(input);

        return new Parser(numbers, operators, lines);
    }

    private static List<Long> listToInt(List<String> lines) {
        int width= lines.stream().mapToInt(String::length).max().orElse(0);

        return IntStream.range(0, width)
                .mapToObj(i -> lines.stream()
                        .map(line -> i < line.length() ? String.valueOf(line.charAt(i)) : " ")
                        .collect(Collectors.joining())
                        .replaceAll(" ", ""))
                .filter(s -> !s.isEmpty())
                .map(Long::parseLong).toList();
    }


    private static String operators(String sum) {
        return getLast(sum.split("\n")).replaceAll(" ", "");

    }

    private static String getLast(String[] split) {
        return split[split.length-1];
    }

    private static List<String> numbers(String sum) {

        return Arrays.stream(sum.split("\n")).
                takeWhile(s -> !(s.contains("+") || s.contains("*")))
                .toList();
    }

    private Parser(List<Long> numbers, String operators, List<String> lines) {
        this.numbers = numbers;
        this.operators = operators;
        this.bounds = Arrays.stream(
                        IntStream.range(0, lines.stream().mapToInt(String::length).max().orElse(0))
                                .mapToObj(x -> lines.stream()
                                        .anyMatch(line -> x < line.length() && Character.isDigit(line.charAt(x))) ? "X" : " ")
                                .collect(Collectors.joining())
                                .split(" ")
                )
                .filter(s -> !s.isEmpty())
                .map(String::length)
                .toList();

    }

    public long operate() {

        return IntStream.range(0, operators.length())
                .mapToLong(this::calculateColumn)
                .sum();
    }

    private long calculateColumn(int colIndex) {
        return operators.charAt(colIndex) == '+'
                ? columnValues(colIndex).sum()
                : columnValues(colIndex).reduce(1, (a, b) -> a * b);
    }

    private LongStream columnValues(int colIndex) {
        return IntStream.range(0, bounds.get(colIndex)).mapToLong(i -> numbers.get(currentIndex(colIndex) + i));
    }

    private int currentIndex(int colIndex) {
        return bounds.stream().limit(colIndex).mapToInt(Integer::intValue).sum();
    }

}
