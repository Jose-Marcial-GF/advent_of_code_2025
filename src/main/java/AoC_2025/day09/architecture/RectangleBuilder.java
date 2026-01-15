package AoC_2025.day09.architecture;

public class RectangleBuilder {
    private Point start;
    private Point end;

    public RectangleBuilder setStart(Point start) {
        this.start = start;
        return this;
    }

    public RectangleBuilder setEnd(Point end) {
        this.end = end;
        return this;
    }

    private Long calculateArea() {
        return width() * height();
    }

    private Long height() {
        return Math.abs(start.y() - end.y()) + 1;
    }

    private Long width() {
        return Math.abs(start.x() - end.x()) + 1;
    }

    public static Rectangle build(Point start, Point end) {
        return new RectangleBuilder().setStart(start).setEnd(end).createRectangle();
    }
    public Rectangle createRectangle() {
        return new Rectangle(start, end, calculateArea());
    }
}