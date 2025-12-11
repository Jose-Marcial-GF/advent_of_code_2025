package AoC_2025.day01.b;

import java.util.Arrays;
import java.util.stream.Stream;

public record DialBuilder(Stream<String> orders) {

    public static DialBuilder with(String orders) {
        return new DialBuilder(Arrays.stream(orders.split("\n")));
    }

    static int updateCount(int position, Dial dial) {
        return dial.count() + timesInZero(position, dial);
    }

    private static int timesInZero(int position, Dial dial) {
        if (position * dial.position() < 0) return Math.abs(position) / 100 + 1;
        if (position == 0) return 1;
        return position / 100;
    }

    public Dial build() {
        return orders.reduce(Dial.create(), DialBuilder::getDial, (a, b) -> b);
    }

    private static Dial getDial(Dial dial, String s) {

        return Dial.create(dial.move(s), updateCount(dial.move(s), dial));
    }

}
