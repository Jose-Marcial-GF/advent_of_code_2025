package AoC_2025.day11.b;



import java.util.HashMap;
import java.util.Map;


public class PathFinder {
    private record SearchState(String currentNode, boolean visitedDac, boolean visitedFft) {}

    public static long solvePart2(DeviceGraph network, String start, String end) {
        return countWithConditions(network, new SearchState(start, false, false), end, new HashMap<>());
    }

    private static long countWithConditions(DeviceGraph network, SearchState state, String end, Map<SearchState, Long> memo) {
        boolean nowDac = state.visitedDac() || state.currentNode().equals("dac");
        boolean nowFft = state.visitedFft() || state.currentNode().equals("fft");
        SearchState currentState = new SearchState(state.currentNode(), nowDac, nowFft);

        if (currentState.currentNode().equals(end)) {
            // SOLO contamos el camino si ambas condiciones son true
            return (currentState.visitedDac() && currentState.visitedFft()) ? 1 : 0;
        }

        // 3. Memoización
        if (memo.containsKey(currentState)) return memo.get(currentState);

        // 4. Exploración (sin Optionals, como pediste)
        Device device = network.findDevice(currentState.currentNode());
        if (device == null) return 0;

        long totalPaths = device.connections().stream()
                .mapToLong(neighbor -> {
                    // Pasamos el testigo de lo que ya hemos visitado a los vecinos
                    SearchState next = new SearchState(neighbor, currentState.visitedDac(), currentState.visitedFft());
                    return countWithConditions(network, next, end, memo);
                })
                .sum();

        memo.put(currentState, totalPaths);
        return totalPaths;
    }

    public static long countAllPaths(DeviceGraph network, String current, String end, Map<String, Long> memo) {
        if (current.equals(end)) return 1;
        if (memo.containsKey(current)) return memo.get(current);

        long count = network.findDevice(current)
                .connections().stream().mapToLong(neighbor -> countAllPaths(network, neighbor, end, memo)).sum();

        memo.put(current, count);
        return count;
    }
}
