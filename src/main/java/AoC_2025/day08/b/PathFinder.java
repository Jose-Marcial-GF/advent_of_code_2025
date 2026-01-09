package AoC_2025.day08.b;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PathFinder {
    private final List<Point> locations;

    public PathFinder(String points) {
        this.locations = getPoints(points).toList();
    }

    private static Stream<Point> getPoints(String points) {
        return lines(points).map(PathFinder::toPoint);
    }

    private static Stream<String> lines(String points) {
        return Arrays.stream(points.split("\n"));
    }

    private static Point toPoint(String point) {
        return Point.of(point.split(","));
    }

    public static PathFinder with(String points) {
        return new PathFinder(points);
    }


    private Stream<Path> generateAllPaths() {
        return IntStream.range(0, locations.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, locations.size())
                        .mapToObj( j -> Path.of(locations.get(i), locations.get(j))))
                .sorted(Comparator.comparingInt(Path::distance));

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

    
}
