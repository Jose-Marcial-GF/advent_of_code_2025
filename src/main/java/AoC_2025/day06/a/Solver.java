package AoC_2025.day06.a;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public record Solver(MathWorkSheet sheet){

    public static Solver with (MathWorkSheet sheet){
        return new Solver(sheet);
    }


    public long calculateTotal() {
        return IntStream.range(0, width())
                .mapToLong(this::solveColumn)
                .sum();
    }

    private long solveColumn(int colIndex) {
        return isAddition(colIndex)
                ? getColumnStream(colIndex).sum()
                : getColumnStream(colIndex).reduce(1, (a, b) -> a * b);
    }

    private boolean isAddition(int colIndex) {
        return sheet.operators().charAt(colIndex) == '+';
    }

    private LongStream getColumnStream(int colIndex) {
        return IntStream.iterate(colIndex, i -> i < sheet.numbers().size(), i -> i + width())
                .mapToLong(sheet.numbers()::get);
    }

    private int width() {
        return sheet.operators().length();
    }
}
