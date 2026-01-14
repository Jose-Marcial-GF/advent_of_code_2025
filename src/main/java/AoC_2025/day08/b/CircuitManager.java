package AoC_2025.day08.b;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public record CircuitManager(List<Set<Point>> circuits) {

    public static CircuitManager with(List<Set<Point>> circuits) {
        return new CircuitManager(circuits);
    }

    public Path getTheLastPath(Stream<Path> paths) {
        return paths.filter(this::isTheLastUnion).findFirst().orElse(null);
    }

    private boolean isTheLastUnion(Path path) {
        mergeCircuits(path);
        return circuits.size() == 1;
    }

    private void mergeCircuits(Path path) {
        mergeCircuits(circuitWith(path.start()), circuitWith(path.end()));
    }

    private void mergeCircuits(Set<Point> circuit1, Set<Point> circuit2) {
        if (circuit1 == null || circuit2 == null || circuit1.equals(circuit2)) return;
        circuit1.addAll(circuit2);
        circuits.remove(circuit2);
    }

    private Set<Point> circuitWith(Point point) {
        return circuits.stream().filter(circuit -> circuit.contains(point)).findFirst().orElse(null);
    }
}
