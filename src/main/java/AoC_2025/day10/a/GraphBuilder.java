package AoC_2025.day10.a;

import AoC_2025.day10.architecture.Graph;
import AoC_2025.day10.architecture.Operator;
import AoC_2025.day10.architecture.State;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GraphBuilder {
    private static final Pattern STATE_PATTERN = Pattern.compile("\\[([.#]+)]");
    private static final Pattern BUTTON_PATTERN = Pattern.compile("\\(([\\d,]+)\\)");
    public static Graph of(String line) {
        return new Graph(
                getOperators(line),
                getGoalState(line));
    }

    private static State getGoalState(String line) {
        Matcher m = STATE_PATTERN.matcher(line);
        m.find();
        List<Integer> bits = m.group(1).chars()
                .mapToObj(c -> c == '#' ? 1 : 0)
                .toList();

        return new State(bits);

    }


    private static List<Operator> getOperators(String line) {
        return BUTTON_PATTERN.matcher(line)
                .results()
                .map(matchResult -> matchResult.group(1))
                .map(s -> Arrays.stream(s.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList())
                .map(Operator::new)
                .toList();
    }
}
