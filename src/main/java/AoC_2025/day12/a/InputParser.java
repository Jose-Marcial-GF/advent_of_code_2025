package AoC_2025.day12.a;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputParser   {
    private final List<Shape> shapes;
    private final List<RegionRequest> requests;

    private static final Pattern SHAPE_PATTERN = Pattern.compile("(?m)^\\d+:\\s*\\R((?:[#.\\s]+\\R?)+)");

    private static final Pattern REGION_PATTERN = Pattern.compile("(\\d+)x(\\d+):\\s*(.+)");


    public static InputParser with(String input) {
        return new InputParser(input);
    }


    private InputParser(String input) {
        this.shapes = toShapes(input);
        this.requests = toRegions(input);
    }


    private static List<Shape> toShapes(String input) {
        return SHAPE_PATTERN.matcher(input).results()
                .map(match1 -> Arrays.stream(match1.group(1).split("\\R"))
                        .map(String::trim)
                        .filter(line -> !line.isEmpty())
                        .collect(Collectors.toList()))
                .map(Shape::new).toList();
    }

    private static List<RegionRequest> toRegions(String input) {
        return REGION_PATTERN.matcher(input).results()
                .map(match -> {
                    int w = Integer.parseInt(match.group(1));
                    int h = Integer.parseInt(match.group(2));
                    int[] counts = Arrays.stream(match.group(3).trim().split("\\s+"))
                            .filter(s -> !s.isBlank())
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    return new RegionRequest(w, h, counts);
                }).toList();
    }

    public List<Shape> getShapes() { return shapes; }
    public List<RegionRequest> getRequests() { return requests; }
}
