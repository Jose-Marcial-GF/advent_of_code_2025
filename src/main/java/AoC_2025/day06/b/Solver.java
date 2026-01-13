package AoC_2025.day06.b;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public record Solver(MathWorkSheet sheet) {
    public static Solver with(MathWorkSheet sheet){
        return new Solver(sheet);
    }

    public long calculateTotal() {
        return IntStream.range(0, sheet.operators().length())
                .mapToLong(this::calculateColumn)
                .sum();
    }

    private long calculateColumn(int colIndex) {
        return sheet.operators().charAt(colIndex) == '+'
                ? columnValues(colIndex).sum()
                : columnValues(colIndex).reduce(1, (a, b) -> a * b);
    }

    private LongStream columnValues(int colIndex) {
        return IntStream.range(0, sheet.bounds().get(colIndex)).mapToLong(i -> sheet.numbers().get(currentIndex(colIndex) + i));
    }

    private int currentIndex(int colIndex) {
        return sheet.bounds().stream().limit(colIndex).mapToInt(Integer::intValue).sum();
    }
}
