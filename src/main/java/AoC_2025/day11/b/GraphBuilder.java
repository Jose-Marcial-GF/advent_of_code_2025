package AoC_2025.day11.b;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GraphBuilder {
    private final DeviceGraph graph = new DeviceGraph();

    public static GraphBuilder of(String input) {
        GraphBuilder builder = new GraphBuilder();
        lines(input).forEach(builder::parseLine);
        return builder;
    }

    private static Stream<String> lines(String input) {
        return Arrays.stream(input.split("\n"));
    }

    private void parseLine(String line) {
        parseLine(line.split(":"));
    }

    private void parseLine(String[] split) {
        graph.addLink(source(split), getConnections(split));
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