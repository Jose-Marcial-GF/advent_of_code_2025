package AoC_2025.day06.a;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record MathWorkSheet(List<Integer> numbers, String operators) {

    public static MathWorkSheet of(String rawInput) {
        return new MathWorkSheet(parseNumbers(rawInput), parseOperators(rawInput));
    }

    private static String parseOperators(String input) {
        return input.chars()
                .filter(c -> c == '+' || c == '*')
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split("\\s"))
                .takeWhile(MathWorkSheet::isNotOperator)
                .map(MathWorkSheet::parseNumber)
                .flatMap(Optional::stream)
                .toList();
    }

    private static boolean isNotOperator(String s) {
        return !(s.contains("+") || s.contains("*"));
    }

    private static Optional<Integer> parseNumber(String s) {
        return Optional.of(s)
                .filter(str -> !str.isBlank())
                .map(Integer::parseInt);
    }


}