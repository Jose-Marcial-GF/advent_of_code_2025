package AoC_2025.day08.a;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public record CircuitManager(List<Set<Point>> circuits) {

    public static CircuitManager with(List<Set<Point>> circuits) {
        return new CircuitManager(circuits);
    }

    public List<Set<Point>> generateCircuit(Stream<Path> limit) {
        limit.forEach(this::mergeCircuits);
        return circuits;
    }


    private void mergeCircuits(Path path) {
        mergeCircuits(circuitWith(path.start()), circuitWith(path.end()));
    }

    private void mergeCircuits(Set<Point> circuit1, Set<Point> circuit2) {
        if (circuit1 == null || circuit2 == null || circuit1.equals(circuit2)) return;
        circuit1.addAll(circuit2);
        circuits.remove(circuit2);
    }


    private Set<Point> circuitWith(Point p) {
        return circuits.stream().filter(circuit -> circuit.contains(p)).findFirst().orElse(null);
    }
}
