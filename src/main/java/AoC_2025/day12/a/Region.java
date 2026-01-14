package AoC_2025.day12.a;


import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Region {
    private final int width;
    private final int height;
    private final boolean[][] grid;
    private int occupiedCells;

    public Region(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new boolean[height][width];
        this.occupiedCells = 0;
    }

    public boolean canPlace(Set<Point> shapeVariant, int startX, int startY) {
        return shapeVariant.stream().noneMatch(p ->
                isOutOfRegion(startX, startY, p) || grid[getTargetY(startY, p)][getTargetX(startX, p)]
        );
    }

    private boolean isOutOfRegion(int startX, int startY, Point p) {
        return getTargetX(startX, p) >= width || getTargetY(startY, p) >= height;
    }

    private static int getTargetY(int startY, Point p) {
        return startY + p.y();
    }

    private static int getTargetX(int startX, Point p) {
        return startX + p.x();
    }

    public void place(Set<Point> shapeVariant, int startX, int startY) {
        for (Point p : shapeVariant) {
            grid[getTargetY(startY, p)][getTargetX(startX, p)] = true;
            occupiedCells++;
        }
    }

    public void remove(Set<Point> shapeVariant, int startX, int startY) {
        for (Point p : shapeVariant) {
            grid[getTargetY(startY, p)][getTargetX(startX, p)] = false;
            occupiedCells--;
        }
    }


    public int width() { return width; }
    public int height() { return height; }
    public int totalArea() { return width * height; }
    public int occupiedArea() { return occupiedCells; }
}
