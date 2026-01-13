package AoC_2025.day06.b;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record MathWorkSheet(List<Long> numbers, String operators, List<Integer> bounds) {
    public static MathWorkSheet of(String input) {

        List<Long> numbers = listToLong(numbers(input.split("\n")));
        String operators = operators(input);
        List<Integer> bounds = mapNumbersInColumnsToX(numbers(input.split("\n")))
                .map(String::length)
                .toList();

        return new MathWorkSheet(numbers, operators, bounds);
    }

    private static List<Long> listToLong(List<String> lines) {
        int width = maxLength(lines);

        return IntStream.range(0, width)
                .mapToObj(i -> lines.stream()
                        .map(line -> i < line.length() ? String.valueOf(line.charAt(i)) : " ")
                        .collect(Collectors.joining())
                        .replaceAll(" ", ""))
                .filter(s -> !s.isEmpty())
                .map(Long::parseLong).toList();
    }


    private static String operators(String sum) {
        return getLastLine(sum.split("\n")).replaceAll(" ", "");

    }

    private static String getLastLine(String[] split) {
        return split[split.length - 1];
    }

    private static List<String> numbers(String[] lines) {
        return Arrays.stream(lines).limit(lines.length-1).toList();
    }

    private static Stream<String> mapNumbersInColumnsToX(List<String> lines) {
        return Arrays.stream(
                IntStream.range(0, maxLength(lines))
                        .mapToObj(x -> lines.stream()
                                .anyMatch(line -> x < line.length() && Character.isDigit(line.charAt(x))) ? "X" : " ")
                        .collect(Collectors.joining())
                        .split(" "));
    }

    private static int maxLength(List<String> lines) {
        return lines.stream().mapToInt(String::length).max().orElse(0);
    }



}
