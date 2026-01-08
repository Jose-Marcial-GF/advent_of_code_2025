package AoC_2025.day04.b;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grid {
    private final char[][] grid;
    private final int de;

    public Grid(char[][] grid, char de) {
        this.grid = grid;
        this.de = de;
    }

    public static Grid of(String grid) {
        return new Grid(toCharArray(grid), '@');
    }

    private static char[][] toCharArray(String grid) {
        return Arrays.stream(grid.split("\n")).map(String::toCharArray).toArray(char[][]::new);
    }

    public long detectFewer() {
        return IntStream.range(0, grid.length*grid[0].length).filter(this::isRoll).filter(i -> cousing(i) <= 4).peek(this::removeRolls).count();
    }

    private void removeRolls(int i) {
        grid[getFila(i)][getColumna(i)] = '.';
    }

    private boolean isRoll(int i) {
        return grid[getFila(i)][getColumna(i)] == '@';
    }

    private int cousing(int i) {
        return topCousing(i) + rowCousing(i) + botCousing(i);
    }

    private int botCousing(int i) {
        return getFila(i)  +1 == grid.length ? 0 : getCousingFrom(getFila(i) + 1, getColumna(i));
    }

    private int rowCousing(int i) {
        return getCousingFrom(getFila(i), getColumna(i));
    }

    private int topCousing(int i) {
        return getFila(i) == 0 ? 0 : getCousingFrom(getFila(i) - 1, getColumna(i));
    }

    private int getColumna(int i) {
        return i % grid[0].length;
    }

    private int getFila(int i) {
        return (i / grid[0].length);
    }

    private int getCousingFrom(int fila, int i) {
        return sumCousing(Arrays.copyOfRange(grid[fila], Math.max(0, i - 1), Math.min(i + 2, grid[fila].length)));
    }

    private int sumCousing(char... chars) {
        return Arrays.toString(chars).chars().reduce(0, (a, b) -> a + isValue(b));
    }

    private int isValue(int b) {
        return b == de ? 1 : 0;
    }

    public String getGrid() {
        return Arrays.stream(grid)
                .map(String::new)
                .collect(Collectors.joining("\n"));
    }
}
