package AoC_2025.day09.a;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record RectangleFinder(List<Point> locations) {

    private static Stream<Point> getPoints(Stream<String> points) {
        return points.map(RectangleFinder::toPoint);
    }

    private static Point toPoint(String point) {
        return Point.of(point.split(","));
    }

    public static RectangleFinder with(Stream<String> points) {
        return new RectangleFinder(getPoints(points).toList());
    }

    public Rectangle findLargestRectangle() {
        return IntStream.range(0, locations.size())
                .boxed()
                .flatMap(
                        i -> IntStream.range(i, locations.size())
                                .mapToObj(j -> RectangleBuilder.build(locations.get(i), locations.get(j)))
                ).max(Comparator.comparingLong(Rectangle::area)).orElse(null);
    }
}
