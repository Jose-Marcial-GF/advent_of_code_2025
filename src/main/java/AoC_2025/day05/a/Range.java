package AoC_2025.day05.a;

import java.util.List;

public record Range(Long from, Long to) {
    private Range merge(Range range2) {
        return new Range(Math.min(range2.from, this.from), Math.max(range2.to, this.to));

    }

    public boolean isMergeable(Range range2) {
        return this.isMergeable(range2.to) || this.isMergeable(range2.from);
    }

    private boolean isMergeable(Long number) {
        return this.from -1 <= number && this.to + 1>= number;
    }

    public boolean contains(Long number) {
        return this.from <= number && this.to >= number;
    }

    public List<Range> mergeOrConcat(Range other) {
        return this.isMergeable(other) ? List.of(this.merge(other)) : List.of(this, other);
    }

}
