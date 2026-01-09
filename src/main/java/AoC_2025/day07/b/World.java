package AoC_2025.day07.b;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record World(Map<Integer, Long> timelines) {
    public World(int startIndex) {
        this(new HashMap<>());
        this.timelines.put(startIndex, 1L);
    }

    public World update(String layer) {

        Map<Integer, Long> collect = timelines.entrySet().stream().flatMap(
                set -> layer.charAt(set.getKey()) == '^' ? splitLight(set) : Stream.of(getPath(set)))
                
                .collect(Collectors.toMap(set -> (int) set[0], set -> set[1], Long::sum));

        return new World(collect);
    }

    private static long[] getPath(Map.Entry<Integer, Long> set) {
        return new long[]{set.getKey(), set.getValue()};
    }

    private static Stream<long[]> splitLight(Map.Entry<Integer, Long> set) {
        return Stream.of(getPath(set, -1), getPath(set, +1));
    }

    private static long[] getPath(Map.Entry<Integer, Long> set, int path) {
        return new long[]{set.getKey() + path, set.getValue()};
    }

    public long getTotalTimelines() {
        return timelines.values().stream()
                .mapToLong(Long::longValue)
                .sum();
    }
}
