package AoC_2025.day10.b;

import AoC_2025.day10.architecture.State;

import java.util.*;
import java.util.OptionalLong;


public record AlgorithmSolver(Map<State, List<Pattern>>patternsByParity, Map<State, OptionalLong>memo) {


    public OptionalLong solve(State goal) {
        if (goal.isZero()) return OptionalLong.of(0);
        if (memo.containsKey(goal)) return memo.get(goal);

        State targetParity = goal.toParity();

        OptionalLong minCost = patternsByParity.getOrDefault(targetParity, Collections.emptyList())
                .stream()
                .filter(pattern -> goal.isValid(pattern.effect()))
                .map(pattern -> calculateRecursiveCost(goal, pattern))
                .filter(OptionalLong::isPresent)
                .mapToLong(OptionalLong::getAsLong)
                .min();

        memo.put(goal, minCost);
        return minCost;
    }

    private OptionalLong calculateRecursiveCost(State currentGoal, Pattern pattern) {
        State nextGoal = currentGoal.minus(pattern.effect()).divideByTwo();
        return solve(nextGoal).stream()
                .map(c -> pattern.cost() + (2 * c))
                .findFirst();
    }

    }