package AoC_2025.day11.a;


import java.util.*;

public class PathFinder {

    public static long countAllPaths(DeviceGraph network, String current, String end, Map<String, Long> memo) {
        if (current.equals(end)) return 1;
        if (memo.containsKey(current)) return memo.get(current);

        long count = network.findDevice(current)
                .connections().stream().mapToLong(neighbor -> countAllPaths(network, neighbor, end, memo)).sum();

        memo.put(current, count);
        return count;
    }
}
