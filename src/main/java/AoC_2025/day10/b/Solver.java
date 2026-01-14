package AoC_2025.day10.b;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.OptionalLong;

public class Solver {
    private final Map<State, List<Pattern>> patternsByParity;
    private final Map<State, OptionalLong> memo;

    private record Pattern(State effect, int cost) {}

    public Solver(Graph graph) {
        this.patternsByParity = precomputePatterns(graph.operators(), graph.goalState().size());
        this.memo = new HashMap<>();
    }

    public OptionalLong solve(State goal) {
        if (goal.isZero()) return OptionalLong.of(0);
        if (memo.containsKey(goal)) return memo.get(goal);

        State targetParity = goal.toParity();

        OptionalLong minCost = patternsByParity.getOrDefault(targetParity, Collections.emptyList())
                .stream()
                .filter(pattern -> goal.isValid(pattern.effect))
                .map(pattern -> calculateRecursiveCost(goal, pattern))
                .filter(OptionalLong::isPresent)
                .mapToLong(OptionalLong::getAsLong)
                .min();

        memo.put(goal, minCost);
        return minCost;
    }

    private OptionalLong calculateRecursiveCost(State currentGoal, Pattern pattern) {
        State nextGoal = currentGoal.minus(pattern.effect).divideByTwo();
        return solve(nextGoal).stream()
                .map(c -> pattern.cost + (2 * c))
                .findFirst();
    }

    private Map<State, List<Pattern>> precomputePatterns(List<Operator> operators, int size) {

        return IntStream.range(0, combinationsPosible(operators))
                .mapToObj(mask -> createPatternFromMask(mask, operators, size))
                .collect(Collectors.groupingBy(
                        pattern -> pattern.effect.toParity()
                ));
    }

    private static int combinationsPosible(List<Operator> operators) {
        return 1 << operators.size();
    }

    private Pattern createPatternFromMask(int mask, List<Operator> operators, int size) {
        List<Operator> activeOps = IntStream.range(0, operators.size())
                .filter(i -> (mask & (1 << i)) != 0)
                .mapToObj(operators::get)
                .toList();

        return new Pattern(addOperatorsEffects(size, activeOps), activeOps.size());
    }


    private static State addOperatorsEffects(int size, List<Operator> activeOps) {
        return activeOps.stream()
                .reduce(State.initial(size), State::add, (s1, s2) -> s2);
    }
}