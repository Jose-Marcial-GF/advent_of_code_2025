package AoC_2025.day06.a;


import AoC_2025.day06.architecture.Sheet;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record HorizontalMathWorkSheet(List<Long> numbers, String operators) implements Sheet {

    public static Sheet of(String rawInput) {
        return new HorizontalMathWorkSheet(parseNumbers(rawInput), parseOperators(rawInput));
    }

    private static String parseOperators(String input) {
        return input.chars()
                .filter(c -> c == '+' || c == '*')
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    private static List<Long> parseNumbers(String input) {
        return Arrays.stream(input.split("\\s"))
                .takeWhile(HorizontalMathWorkSheet::isNotOperator)
                .map(HorizontalMathWorkSheet::parseNumber)
                .flatMap(Optional::stream)
                .toList();
    }

    private static boolean isNotOperator(String s) {
        return !(s.contains("+") || s.contains("*"));
    }

    private static Optional<Long> parseNumber(String s) {
        return Optional.of(s)
                .filter(str -> !str.isBlank())
                .map(Long::parseLong);
    }



}