package AoC_2025.day09.b;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Polygon(List<Point> vertex, Map<Long, List<Interval>> rowCache, long[] criticalYLevels) {
    public  static Polygon with(Stream<String> points) {
        List<Point> vertex = points.map(Polygon::toPoint).toList();

        long[] yLevels = vertex.stream()
                .mapToLong(Point::y)
                .distinct()
                .sorted()
                .toArray();
        return new Polygon(vertex, new HashMap<>(), yLevels);
    }


    public boolean isSegmentOutside(long startX, long endX, long y) {
        return rowCache.computeIfAbsent(y, this::calculateIntervalsForY)
                .stream().
                noneMatch(interval -> interval.contains(startX, endX));
    }


    private List<Interval> calculateIntervalsForY(long y) {
        // 1. Obtenemos todos los lados del polígono como flujo de objetos 'Edge'
        List<Edge> edges = IntStream.range(0, vertex.size())
                .mapToObj(this::getEdge)
                .toList();

        // 2. Concatenamos intervalos horizontales (colineales) e intervalos de intersección
        List<Interval> rawIntervals = Stream.concat(
                findColinearIntervals(edges, y),
                findIntersectionIntervals(edges, y)
        ).sorted(Comparator.comparingLong(Interval::start)).toList(); // Ordenamos antes de fusionar

        // 3. Delegamos en tu método existente para fusionar solapamientos
        // Nota: rawIntervals es inmutable aquí, si getIntervals requiere mutable, envuélvelo en new ArrayList<>(...)
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
                // CAMBIO AQUÍ: Usamos lógica manual semi-abierta [minY, maxY)
                // Excluimos el punto más alto de la línea vertical para no duplicar
                // la intersección en las esquinas superiores.
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

    // Helper para crear el objeto Edge sin ensuciar el código principal con índices módulo size
    private Edge getEdge(int i) {
        return new Edge(vertex.get(i), vertex.get((i + 1) % vertex.size()));
    }

    private static List<Interval> getIntervals(List<Interval> raw) {
        return raw.stream()
                .sorted(Comparator.comparingLong(Interval::start))
                .collect(IntervalChain::new, IntervalChain::add, IntervalChain::merge)
                .toList();
    }

    private static Point toPoint(String point) {
        return Point.of(point.split(","));
    }


}
