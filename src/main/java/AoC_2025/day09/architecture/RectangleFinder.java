package AoC_2025.day09.architecture;

import AoC_2025.Solver;
import AoC_2025.day09.b.Polygon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public record RectangleFinder(List<Point> locations) implements Solver.SolverA, Solver.SolverB {


    public static RectangleFinder with(Stream<String> points) {
        return new RectangleFinder(getPoints(points).toList());
    }

    public Rectangle findLargestRectangleInto(Polygon polygon) {
        return streamAllRectangles()
                .filter(rect -> isValid(rect, polygon))
                .findFirst()
                .orElse(null);
    }
    private Rectangle findLargestRectangle() {
        return streamAllRectangles().findFirst().orElse(null);
    }

    private Stream<Rectangle> streamAllRectangles() {
        return locations.stream()
                .flatMap(p1 -> locations.stream()
                        .map(p2 -> RectangleBuilder.build(p1, p2)))
                .sorted(Comparator.comparingLong(Rectangle::area).reversed());
    }

    private boolean isValid(Rectangle rectangle, Polygon polygon) {
        LongStream yLevelsToCheck = LongStream.concat(
                LongStream.of(rectangle.min(Point::y), rectangle.max(Point::y)),

                Arrays.stream(polygon.criticalYLevels())
                        .filter(rectangle::strictlyContainsY)
        );

        return yLevelsToCheck.noneMatch(y ->
                polygon.isSegmentOutside(rectangle.min(Point::x), rectangle.max(Point::x), y)
        );
    }
    private static Stream<Point> getPoints(Stream<String> points) {
        return points.map(RectangleFinder::toPoint);
    }

    private static Point toPoint(String point) {
        return Point.of(point.split(","));
    }

    @Override
    public long solveA() {
        return findLargestRectangle().area();
    }

    @Override
    public long solveB() {
        return findLargestRectangleInto(Polygon.with(locations)).area();
    }
}
