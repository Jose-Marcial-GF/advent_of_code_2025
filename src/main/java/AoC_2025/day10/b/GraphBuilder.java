package AoC_2025.day10.b;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GraphBuilder {
    private static final Pattern GOAL_PATTERN = Pattern.compile("\\{([\\d,]+)}");
    private static final Pattern BUTTON_PATTERN = Pattern.compile("\\(([\\d,]+)\\)");

    public static Graph of(String line) {
        return new Graph(parseOperators(line), parseGoal(line));
    }

    private static State parseGoal(String line) {
        Matcher m = GOAL_PATTERN.matcher(line);
        if (m.find()) {
            return new State(parseIntList(m.group(1)));
        }
        throw new IllegalArgumentException("No se encontró el objetivo {...} en la línea: " + line);
    }

    private static List<Operator> parseOperators(String line) {
        return BUTTON_PATTERN.matcher(line)
                .results()
                .map(res -> res.group(1))
                .map(GraphBuilder::parseIntList)
                .map(Operator::new)
                .toList();
    }

    private static List<Integer> parseIntList(String raw) {
        return Arrays.stream(raw.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }
}