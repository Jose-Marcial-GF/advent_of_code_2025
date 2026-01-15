package AoC_2025.day11.a;


import AoC_2025.day11.architecture.DeviceGraph;

import java.util.*;

public record PathFinder(DeviceGraph deviceGraph) {


    public  static PathFinder with(DeviceGraph deviceGraph) {
        return new PathFinder(deviceGraph);
    }

    private long countAllPaths(String current, String end, Map<String, Long> memo) {
        if (current.equals(end)) return 1;
        if (memo.containsKey(current)) return memo.get(current);

        long count = deviceGraph.findDevice(current)
                .connections().stream().mapToLong(neighbor -> countAllPaths(neighbor, end, memo)).sum();

        memo.put(current, count);
        return count;
    }

    public long solve(String start, String end) {
        return countAllPaths(start, end, new HashMap<>());
    }
}
