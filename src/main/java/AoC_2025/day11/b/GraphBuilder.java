package AoC_2025.day11.b;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record GraphBuilder(DeviceGraph graph) {
    public static GraphBuilder of(String input) {
        return new GraphBuilder(DeviceGraph.with(getMap(input)));
    }

    private static Map<String, Device> getMap(String input) {
        return input.lines().map(GraphBuilder::parseLine)
                .flatMap(map -> map.entrySet().stream()).
                collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Entry -> new Device(Entry.getKey(), Entry.getValue())
                ));
    }


    private static Map<String, Set<String>>  parseLine(String line) {
        return parseLine(line.split(":"));
    }

    private static Map<String, Set<String>> parseLine(String[] split) {
        return Map.of(source(split), getConnections(split));
    }

    private static String source(String[] split) {
        return split[0];
    }

    private static Set<String> getConnections(String[] split) {
        return Stream.of(split[1].trim().split(" +")).collect(Collectors.toSet());
    }

    public DeviceGraph build() {
        return graph;
    }
}