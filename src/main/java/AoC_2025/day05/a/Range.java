package AoC_2025.day05.a;

import java.util.List;

public record Range(Long from, Long to) {
    private Range merge(Range range) {
        return new Range(Math.min(range.from, this.from), Math.max(range.to, this.to));

    }

    public boolean isMergeable(Range range) {
        return this.isMergeable(range.to) || this.isMergeable(range.from);
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
