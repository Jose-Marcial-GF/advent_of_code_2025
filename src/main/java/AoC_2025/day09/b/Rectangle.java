package AoC_2025.day09.b;


import java.util.function.Function;

public record Rectangle(Point start, Point end, Long area) {
    public Long min(Function<Point, Long> direction){
        return Math.min(direction.apply(start), direction.apply(start));
    }

    public Long max(Function<Point, Long> direction){
        return Math.min(direction.apply(start), direction.apply(start));
    }
}
