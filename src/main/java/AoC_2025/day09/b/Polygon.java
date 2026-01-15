package AoC_2025.day09.b;

import AoC_2025.day09.architecture.Point;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Polygon(List<Point> vertex, Map<Long, List<Interval>> rowCache, long[] criticalYLevels) {
    public  static Polygon with(List<Point> vertex) {
        return new Polygon(vertex, new HashMap<>(), getYLevels(vertex));
    }

    private static long[] getYLevels(List<Point> vertex) {
        return vertex.stream()
                .mapToLong(Point::y)
                .distinct()
                .sorted()
                .toArray();
    }


    public boolean isSegmentOutside(long startX, long endX, long y) {
        return rowCache.computeIfAbsent(y, this::calculateIntervalsForY)
                .stream().
                noneMatch(interval -> interval.contains(startX, endX));
    }


    private List<Interval> calculateIntervalsForY(long y) {
        List<Edge> edges = IntStream.range(0, vertex.size())
                .mapToObj(this::getEdge)
                .toList();

        List<Interval> rawIntervals = Stream.concat(
                findColinearIntervals(edges, y),
                findIntersectionIntervals(edges, y)
        ).sorted(Comparator.comparingLong(Interval::start)).toList();

        return getIntervals(new ArrayList<>(rawIntervals));
    }


    private Stream<Interval> findColinearIntervals(List<Edge> edges, long y) {
        return edges.stream()
                .filter(e -> e.isHorizontalAt(y))
                .map(Edge::toInterval);
    }

    private Stream<Interval> findIntersectionIntervals(List<Edge> edges, long y) {
        List<Long> xCoords = edges.stream()
                .filter(e -> !e.isHorizontalAt(y))
                .filter(e -> {
                    long minY = Math.min(e.start().y(), e.end().y());
                    long maxY = Math.max(e.start().y(), e.end().y());
                    return y >= minY && y < maxY;
                })
                .map(e -> e.start().x())
                .sorted()
                .toList();

        return IntStream.iterate(0, i -> i < xCoords.size() - 1, i -> i + 2)
                .mapToObj(i -> new Interval(xCoords.get(i), xCoords.get(i + 1)));
    }

    private Edge getEdge(int i) {
        return new Edge(vertex.get(i), vertex.get((i + 1) % vertex.size()));
    }

    private static List<Interval> getIntervals(List<Interval> raw) {
        return raw.stream()
                .sorted(Comparator.comparingLong(Interval::start))
                .collect(IntervalChain::new, IntervalChain::add, IntervalChain::merge)
                .toList();
    }


}
