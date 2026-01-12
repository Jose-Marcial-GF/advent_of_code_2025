package AoC_2025.day04.b;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Grid(char[][] grid, int delimitator) {

    public static Grid of(Stream<String> grid) {
        return new Grid(toCharArray(grid), '@');
    }

    private static char[][] toCharArray(Stream<String> grid) {
        return grid.map(String::toCharArray).toArray(char[][]::new);
    }

    public static Grid of(char[][] grid) {
        return new Grid(grid, '@');
    }

    public long detectFewer(int bound) {
        return IntStream.range(0, grid.length * grid[0].length).filter(this::isRoll).filter(roll -> neighbors(roll) <= bound).peek(this::removeRolls).count();
    }
    private void removeRolls(int roll) {
        grid[rowOf(roll)][columnOf(roll)] = '.';
    }
    private boolean isRoll(int indexOfChar) {
        return grid[rowOf(indexOfChar)][columnOf(indexOfChar)] == '@';
    }

    private int neighbors(int roll) {
        return topNeighbors(roll) + rowNeighbor(roll) + botNeighbor(roll);
    }

    private int botNeighbor(int roll) {
        return rowOf(roll) + 1 == grid.length ? 0 : getNeighborFrom(rowOf(roll) + 1, columnOf(roll));
    }

    private int rowNeighbor(int roll) {
        return getNeighborFrom(rowOf(roll), columnOf(roll));
    }

    private int topNeighbors(int roll) {
        return rowOf(roll) == 0 ? 0 : getNeighborFrom(rowOf(roll) - 1, columnOf(roll));
    }

    private int columnOf(int roll) {
        return roll % grid[0].length;
    }

    private int rowOf(int roll) {
        return (roll / grid[0].length);
    }

    private int getNeighborFrom(int fila, int i) {
        return sumNeighbor(Arrays.copyOfRange(grid[fila], Math.max(0, i - 1), Math.min(i + 2, grid[fila].length)));
    }

    private int sumNeighbor(char... chars) {
        return Arrays.toString(chars).chars().reduce(0, (a, b) -> a + isValue(b));
    }

    private int isValue(int b) {
        return b == delimitator ? 1 : 0;
    }
}
