package AoC_2025.day01.a;

import java.util.Arrays;
import java.util.stream.Stream;

public record DialBuilder(Stream<String> orders) {

    public static DialBuilder with(String orders) {
        return new DialBuilder(Arrays.stream(orders.split("\n")));
    }

    public Dial build() {
        return orders.reduce(Dial.initialize(), DialBuilder::createNewDial, (a, b) -> b);
    }

    private static Dial createNewDial(Dial dial, String s) {
        return Dial.in(dial.move(s), updateCount(dial.move(s), dial.count()));
    }

    static int updateCount(int position, int count) {
        return count + sumIfRequire(position);
    }

    private static int sumIfRequire(int position) {
        return position % 100 == 0 ? 1 : 0;
    }

}