package AoC_2025.day10.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public record State(List<Integer> lights) {

    public static State initial(int size) {
        return new State(Collections.nCopies(size, 0));
    }

    public int size() {
        return lights.size();
    }

    public State apply(Operator op) {
        return new State(IntStream.range(0, lights.size())
                .mapToObj(i -> op.lights().contains(i)
                        ? lights.get(i) ^ 1
                        : lights.get(i))
                .toList());

    }

}
