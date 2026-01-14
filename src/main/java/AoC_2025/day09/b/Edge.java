package AoC_2025.day09.b;

public record Edge(Point start, Point end) {

    boolean isHorizontalAt(long y) {
        return start.y() == y && end.y() == y;
    }

    Interval toInterval() {
        return new Interval(Math.min(start.x(), end.x()), Math.max(start.x(), end.x()));
    }
}