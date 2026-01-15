package AoC_2025.day09.architecture;


import java.util.function.Function;

public record Rectangle(Point start, Point end, Long area) {
    public Long min(Function<Point, Long> direction){
        return Math.min(direction.apply(start), direction.apply(end));
    }

    public Long max(Function<Point, Long> direction){
        return Math.max(direction.apply(start), direction.apply(end));
    }

    public boolean strictlyContainsY(long y) {
        return y > min(Point::y) && y < max(Point::y);
    }
}
