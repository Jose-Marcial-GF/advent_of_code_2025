package AoC_2025.day08.a;

import java.util.function.Function;

public class Path {
    private final Point start;

    private final Point end;
    private final int distance;

    private Path(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.distance = calculateDistance();
    }

    private int calculateDistance() {
        return (int) Math.sqrt(delta(Point::x) + delta(Point::y) + delta(Point::z));
    }

    public static Path of(Point start, Point point) {
        return new Path(start, point);
    }

    public int distance() {
        return distance;
    }

    public Point start() {
        return start;
    }

    public Point end() {
        return end;
    }


    private double delta(Function<Point, Integer> coordinate) {
        return Math.pow(coordinate.apply(start) - coordinate.apply(end), 2);
    }
}
