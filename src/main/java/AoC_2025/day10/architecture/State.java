package AoC_2025.day10.architecture;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public record State(List<Integer> joltage) {

    public static State initial(int size) {
        return new State(Collections.nCopies(size, 0));
    }

    public boolean isZero() {
        return joltage.stream().allMatch(v -> v == 0);
    }

    public State toParity() {
        return new State(joltage.stream().map(v -> v % 2).toList());
    }

    public State minus(State other) {
        return new State(IntStream.range(0, joltage.size())
                .mapToObj(i -> joltage.get(i) - other.joltage().get(i))
                .toList());
    }

    public State divideByTwo() {
        return new State(joltage.stream().map(v -> v / 2).toList());
    }

    public boolean isValid(State other) {
        return IntStream.range(0, joltage.size())
                .allMatch(i -> this.joltage.get(i) >= other.joltage().get(i));
    }

    public State add(Operator operator) {
        return new State(IntStream.range(0, joltage.size())
                .mapToObj(i -> operator.lights().contains(i) ? joltage.get(i) + 1 : joltage.get(i))
                .toList());
    }

    public int size() {
        return joltage.size();
    }

    public State apply(Operator op) {
        return new State(IntStream.range(0, joltage.size())
                .mapToObj(i -> op.lights().contains(i)
                        ? joltage.get(i) ^ 1
                        : joltage.get(i))
                .toList());

    }
}