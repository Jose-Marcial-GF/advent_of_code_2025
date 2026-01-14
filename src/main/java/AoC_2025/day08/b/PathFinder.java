package AoC_2025.day08.b;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record PathFinder(List<Point> locations) {

    public static PathFinder with(Stream<String> points) {
        return new PathFinder(toPoints(points).toList());
    }

    private Stream<Path> generateAllPaths() {
        return IntStream.range(0, locations.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, locations.size())
                        .mapToObj(j -> Path.of(locations.get(i), locations.get(j))))
                .sorted(Comparator.comparingDouble(Path::distance));

    }

    public long solve() {
        return multiplayDistance(lastPath());
    }

    private Path lastPath() {
        return CircuitManager.with(initCircuits()).getTheLastPath(generateAllPaths());
    }

    private static long multiplayDistance(Path path) {
        return (long) path.start().x() * path.end().x();
    }

    private ArrayList<Set<Point>> initCircuits() {
        return locations.stream()
                .map(p -> new HashSet<>(List.of(p)))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    private static Stream<Point> toPoints(Stream<String> points) {
        return points.map(PathFinder::toPoint);
    }

    private static Point toPoint(String point) {
        return Point.of(point.split(","));
    }


}
