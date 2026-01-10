package AoC_2025.day09.b;

import java.util.*;
import java.util.stream.Stream;

public class Polygon {
    private final List<Point> vertices;
    private final Map<Long, List<Interval>> rowCache = new HashMap<>();
    private final long[] criticalYLevels;

    public Polygon(String vertices) {
        this.vertices = getPoints(vertices).toList();
        long mnX = Long.MAX_VALUE, mxX = Long.MIN_VALUE;
        long mnY = Long.MAX_VALUE, mxY = Long.MIN_VALUE;

        SortedSet<Long> yLevels = new TreeSet<>();
        for (Point p : Polygon.this.vertices) {
            if (p.x() < mnX) mnX = p.x();
            if (p.x() > mxX) mxX = p.x();
            if (p.y() < mnY) mnY = p.y();
            if (p.y() > mxY) mxY = p.y();
            yLevels.add(p.y());
        }
        this.criticalYLevels = yLevels.stream().mapToLong(l -> l).toArray();
    }

    public long[]criticalYLevels() { return criticalYLevels; }

    public boolean isSegmentInside(long startX, long endX, long y) {

        return rowCache.computeIfAbsent(y, this::calculateIntervalsForY)
                .stream().anyMatch(
                        interval -> interval.contains(startX, endX)
                );
    }


    private List<Interval> calculateIntervalsForY(long y) {
        List<Long> intersections = new ArrayList<>();
        List<Interval> rawIntervals = new ArrayList<>();

        for (int i = 0; i < vertices.size(); i++) {
            Point a = vertices.get(i);
            Point b = vertices.get((i + 1) % vertices.size());

            if (a.y() == y && b.y() == y) {
                rawIntervals.add(new Interval(Math.min(a.x(), b.x()), Math.max(a.x(), b.x())));
            }
            else if (new Interval(Math.min(a.y(), b.y()), Math.max(a.y(), b.y())).contains(y)) {
                intersections.add(a.x());
            }
        }

        Collections.sort(intersections);

        for (int i = 0; i < intersections.size(); i += 2) {
            if (i + 1 < intersections.size()) {
                long start = intersections.get(i);
                long end = intersections.get(i + 1);

                if (start <= end) {
                    rawIntervals.add(new Interval(start, end));
                }
            }
        }

        if (rawIntervals.isEmpty()) return rawIntervals;

        rawIntervals.sort(Comparator.comparingLong(Interval::start));

        List<Interval> merged = getIntervals(rawIntervals);

        return merged;
    }

    private static List<Interval> getIntervals(List<Interval> raw) {
        if (raw.isEmpty()) return Collections.emptyList();

        raw.sort(Comparator.comparingLong(Interval::start));

        List<Interval> merged = new ArrayList<>();
        Interval current = raw.get(0);

        for (int i = 1; i < raw.size(); i++) {
            Interval next = raw.get(i);

            if (current.connectsWith(next)) {
                current = current.merge(next);
            } else {
                merged.add(current);
                current = next;
            }
        }
        merged.add(current);
        return merged;
    }


    private static Stream<Point> getPoints(String points) {
        return lines(points).map(Polygon::toPoint);
    }

    private static Stream<String> lines(String points) {
        return Arrays.stream(points.split("\n"));
    }

    private static Point toPoint(String point) {
        return Point.of(point.split(","));
    }


}
