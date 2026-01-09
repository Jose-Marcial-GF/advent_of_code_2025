package AoC_2025.day08.a;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class CircuitManager {
    public static List<Set<Point>> generateCircuit(List<Set<Point>> circuits, Stream<Path> limit) {
        limit.forEach(path -> {
                    Set<Point> c1 = findCircuit(path.start(), circuits);
                    Set<Point> c2 = findCircuit(path.end(), circuits);

                    if (c1 != null && c2 != null && c1 != c2) {
                        c1.addAll(c2);
                        circuits.remove(c2);
                    }
                });
        return circuits;
    }

    private static Set<Point> findCircuit(Point p, List<Set<Point>> circuits) {
        for (Set<Point> circuit : circuits) {
            if (circuit.contains(p)) {
                return circuit;
            }
        }
        return null;
    }
}
