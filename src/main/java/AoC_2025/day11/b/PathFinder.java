package AoC_2025.day11.b;



import java.util.HashMap;
import java.util.Map;


public record PathFinder(DeviceGraph deviceGraph) {

    public static PathFinder with(DeviceGraph network){
        return new PathFinder(network);
    }

    public long solve(String start, String end) {
        return countWithConditions(new SearchState(start, false, false), end, new HashMap<>());
    }

    private long countWithConditions(SearchState currentState, String end, Map<SearchState, Long> memo) {

        if (isEnd(currentState, end)) return isValidEnd(currentState);

        if (memo.containsKey(currentState)) return memo.get(currentState);

        memo.put(currentState, getTotalPaths(currentState, end, memo));
        return memo.get(currentState);
    }

    private long getTotalPaths(SearchState currentState, String end, Map<SearchState, Long> memo) {
        return deviceGraph.findDevice(currentState.node()).connections().stream()
                .mapToLong(neighbor -> countWithConditions(SearchState.next(neighbor, currentState.visitedDac(), currentState.visitedFft()), end, memo))
                .sum();
    }

    private int isValidEnd(SearchState currentState) {
        return (currentState.visitedDac() && currentState.visitedFft()) ? 1 : 0;
    }

    private boolean isEnd(SearchState currentState, String end) {
        return currentState.node().equals(end);
    }

}
