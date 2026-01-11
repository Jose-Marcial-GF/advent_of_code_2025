package AoC_2025.day10.a;

import java.util.Objects;
import java.util.stream.Stream;

record SearchNode(State state, SearchNode parent) {

    public long getDepth() {
        SearchNode current = this;
        return Stream.iterate(current, Objects::nonNull, SearchNode::parent)
                .count() - 1;
    }
}
