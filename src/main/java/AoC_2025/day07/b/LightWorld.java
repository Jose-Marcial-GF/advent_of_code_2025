package AoC_2025.day07.b;

import AoC_2025.day07.architecture.World;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record LightWorld(Map<Integer, Long> timelines) implements World {

    public LightWorld update(String layer) {

        Map<Integer, Long> collect = timelines.entrySet().stream().flatMap(
                set -> splitLightIfRequire(layer, set))
                
                .collect(Collectors.toMap(set -> (int) set[0], set -> set[1], Long::sum));

        return new LightWorld(collect);
    }

    public static World initialize(String firstLine){
            return new LightWorld(Map.of(firstLine.indexOf('S'), 1L));

    }

    @Override
    public Long getReflexions() {
        return timelines.values().stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    private static Stream<long[]> splitLightIfRequire(String layer, Map.Entry<Integer, Long> set) {
        return layer.charAt(set.getKey()) == '^' ? splitLight(set) : Stream.of(getPath(set));
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

}
