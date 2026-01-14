package AoC_2025.day09.b;

import java.util.Optional;

public record Interval(Long start, Long end) {

    public boolean connectsWith(Interval next) {
        return this.end + 1 >= next.start;
    }

    public Interval merge(Interval next) {
        return new Interval(
                Math.min(this.start, next.start),
                Math.max(this.end, next.end)
        );
    }


    public boolean contains(long minX, long maxX) {
        return this.start <= minX && this.end >= maxX;
    }

    public boolean contains(long x) {
        return this.start <= x && this.end > x;
    }

    public Optional<Interval> absorb(Interval next) {
        return (connectsWith(next)) ? Optional.of(merge(next)) : Optional.empty();
    }
}
