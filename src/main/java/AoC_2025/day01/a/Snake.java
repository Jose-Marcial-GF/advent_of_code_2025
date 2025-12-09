package AoC_2025.day01.a;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Snake {
    private final int position;
    private final int count;

    private Snake(int position, int count) {
        this.position = validate(position);
        this.count = upDate(count, validate(position));
    }

    private static int upDate(int count, int position) {
        return position == 0 ? count + 1 : count;
    }

    private int validate(int position) {
        int x = (Math.abs(position) / 100 <= 0) ? 1 : Math.abs(position) / 100;
        return (position + 100 + 100 * x) % (100);
    }

    public static Snake create() {
        return new Snake(50, 0);
    }

    private static Snake in(int position, int count, Stream<String> movements) {
        String movementsString = toString(movements);
        if (movementsString.isEmpty()) return Snake.in(position, count);
        return new Snake(position, count).move(movementsString);
    }

    private static Snake in(int position, int count) {
        return new Snake(position, count);
    }


    private static String toString(Stream<String> movements) {
        return movements.collect(Collectors.joining("\n"));
    }


    public Snake move(String directions) {
        return Snake.in(position + toInt(getFirst(toStream(directions))), count, getRest(toStream(directions)));
    }

    private static String getFirst(Stream<String> directions) {
        return directions.findFirst().orElse("0");
    }

    private Stream<String> getRest(Stream<String> directions) {
        return directions.skip(1);
    }

    private Stream<String> toStream(String direction) {
        return Arrays.stream(direction.split("\n"));
    }

    public int position() {
        return this.position;
    }

    private int toInt(String direction) {
        return Integer.parseInt(
                direction
                        .replace("L", "-")
                        .replace("R", "+")
        );
    }

    public int count() {
        return this.count;
    }
}
