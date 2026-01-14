package AoC_2025.day09.b;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public record RectangleFinder(List<Point> locations) {


    public static RectangleFinder with(Stream<String> points) {
        return new RectangleFinder(getPoints(points).toList());
    }

    public Rectangle findLargestRectangleInto(Polygon polygon) {
        return streamAllRectangles()
                .filter(rect -> isValid(rect, polygon))
                .findFirst()
                .orElse(null);
    }

    // Extrajimos la generación de rectángulos para limpiar el método principal
    private Stream<Rectangle> streamAllRectangles() {
        return locations.stream()
                .flatMap(p1 -> locations.stream()
                        .map(p2 -> RectangleBuilder.build(p1, p2)))
                .sorted(Comparator.comparingLong(Rectangle::area).reversed());
    }

    private boolean isValid(Rectangle rectangle, Polygon polygon) {
        // 1. Identificamos qué líneas horizontales ("cortes") debemos validar
        LongStream yLevelsToCheck = LongStream.concat(
                // Los bordes superior e inferior del rectángulo siempre se chequean
                LongStream.of(rectangle.min(Point::y), rectangle.max(Point::y)),

                // Más cualquier nivel crítico del polígono que pase POR DENTRO del rectángulo
                Arrays.stream(polygon.criticalYLevels())
                        .filter(rectangle::strictlyContainsY)
        );

        // 2. Validamos que NINGUNO de esos cortes se salga del polígono
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
}
