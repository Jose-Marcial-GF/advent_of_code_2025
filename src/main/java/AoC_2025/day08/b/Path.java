package AoC_2025.day08.b;

import java.util.function.Function;

public record Path(Point start, Point end) {

    private double calculateDistance() {
        return Math.sqrt(delta(Point::x) + delta(Point::y) + delta(Point::z));
    }

    public static Path of(Point start, Point point) {
        return new Path(start, point);
    }

    public double distance() {
        return calculateDistance();
    }


    private double delta(Function<Point, Integer> coordinate) {
        return Math.pow(coordinate.apply(start) - coordinate.apply(end), 2);
    }
}
