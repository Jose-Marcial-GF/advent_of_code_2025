package AoC_2025.day09.b;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IntervalChain {
    private final LinkedList<Interval> chain = new LinkedList<>();

    public void add(Interval next) {
        if (chain.isEmpty()) {
            chain.add(next);
            return;
        }
        chain.getLast().absorb(next)
                .ifPresentOrElse(
                        this::replaceLast,
                        () -> chain.add(next)
                );
    }

    private void replaceLast(Interval merged) {
        chain.removeLast();
        chain.add(merged);
    }

    public IntervalChain merge(IntervalChain other) {
        other.chain.forEach(this::add);
        return this;
    }

    public List<Interval> toList() {
        return new ArrayList<>(chain);
    }
}
