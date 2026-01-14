package AoC_2025.day12.a;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Shape {
    private final Set<Set<Point>> variants;
    private final int area;

    public Shape(List<String> grid) {
        Set<Point> basePoints = IntStream.range(0, grid.size())
                .boxed()
                .flatMap(y -> IntStream.range(0, grid.get(y).length())
                        .filter(x -> grid.get(y).charAt(x) == '#')
                        .mapToObj(x -> new Point(x, y)))
                .collect(Collectors.toSet());

        this.area = basePoints.size();
        this.variants = generateAllVariants(basePoints);
    }

    private Set<Set<Point>> generateAllVariants(Set<Point> base) {
        return Stream.iterate(base, this::rotate)
                .limit(2)
                .flatMap(p -> Stream.of(p, reflect(p)))
                .collect(Collectors.toSet());
    }

    private Set<Point> rotate(Set<Point> pts) {
        return pts.stream().map(p -> new Point(2-p.y(), p.x())).collect(Collectors.toSet());
    }

    private Set<Point> reflect(Set<Point> pts) {
        return pts.stream().map(p -> new Point(2-p.x(), p.y())).collect(Collectors.toSet());
    }

    public Set<Set<Point>> getVariants() { return variants; }
    public int getArea() { return area; }


}