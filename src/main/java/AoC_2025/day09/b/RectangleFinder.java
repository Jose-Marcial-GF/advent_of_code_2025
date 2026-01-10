package AoC_2025.day09.b;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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

    public Rectangle findLargestRectangleInto(Polygon polygon) {
        return IntStream.range(0, locations.size())
                .boxed()
                .flatMap(
                        i -> IntStream.range(i, locations.size())
                                .mapToObj(j -> RectangleBuilder.build(locations.get(i), locations.get(j)))
                )
                .sorted(Comparator.comparingLong(Rectangle::area).reversed())
                // 2. Validar usando el método "On-the-fly"
                .filter(rect -> isValid(rect, polygon))
                .findFirst()
                .orElse(null);
    }

    private boolean isValid(Rectangle r, Polygon polygon) {
            long x1 = Math.min(r.start().x(), r.end().x());
            long x2 = Math.max(r.start().x(), r.end().x());
            long y1 = Math.min(r.start().y(), r.end().y());
            long y2 = Math.max(r.start().y(), r.end().y());

            if (!polygon.isSegmentInside(x1, x2, y1)) return false;

            if (!polygon.isSegmentInside(x1, x2, y2)) return false;

            long[] levels = polygon.criticalYLevels();

            int index = Arrays.binarySearch(levels, y1);

                index++;
            for (int i = index; i < levels.length; i++) {
                long y = levels[i];
                if (y >= y2) break;
                if (!polygon.isSegmentInside(x1, x2, y)) {
                    return false;
                }
            }

            return true;
        }
}
