package AoC_2025.day08.architecture;

import AoC_2025.Solver;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record PathFinder(List<Point> locations) implements Solver.SolverA, Solver.SolverB {
    public static PathFinder with(Stream<String> locations) {
        return new PathFinder(toPoints(locations).toList());
    }

    private static Stream<Point> toPoints(Stream<String> points) {
        return points.map(PathFinder::toPoint);
    }

    private static Point toPoint(String point) {
        return Point.of(point.split(","));
    }



    private Stream<Path> generateAllPaths() {
        return IntStream.range(0, locations.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, locations.size())
                        .mapToObj(j -> Path.of(locations.get(i), locations.get(j))))
                .sorted(Comparator.comparingDouble(Path::distance));

    }

    private List<Set<Point>> circuits() {
        return CircuitManager.with(initialCircuits())
                             .generateCircuit(generateAllPaths().limit(1000));
    }

    private static long getLongest(List<Set<Point>> circuits) {
        return circuits.stream()
                .map(Set::size)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .reduce(1, (a, b) -> a * b);
    }

    private List<Set<Point>> initialCircuits() {
        return locations.stream()
                .map(p -> new HashSet<>(List.of(p)))
                .collect(Collectors.toCollection(ArrayList::new));
    }


    private Path lastPath() {
        return CircuitManager.with(initialCircuits()).getTheLastPath(generateAllPaths());
    }

    private static long multiplayDistance(Path path) {
        return (long) path.start().x() * path.end().x();
    }


    @Override
    public long solveA() {
        return getLongest(circuits());
    }

    @Override
    public long solveB() {
        return multiplayDistance(lastPath());
    }
}
