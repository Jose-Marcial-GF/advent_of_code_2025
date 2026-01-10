package AoC_2025.day09.a;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RectangleFinder {
    private final List<Point> locations;

    public RectangleFinder(String points) {
        this.locations = getPoints(points).toList();
    }

    private static Stream<Point> getPoints(String points) {
        return lines(points).map(RectangleFinder::toPoint);
    }

    private static Stream<String> lines(String points) {
        return Arrays.stream(points.split("\n"));
    }

    private static Point toPoint(String point) {
        return Point.of(point.split(","));
    }

    public static RectangleFinder with(String points) {
        return new RectangleFinder(points);
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
