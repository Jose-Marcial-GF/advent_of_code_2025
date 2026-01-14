package AoC_2025.day01.b;

import AoC_2025.Solver;
import AoC_2025.day01.architecture.Dial;

import java.util.stream.Stream;

public record DialBuilder(Stream<String> orders) implements Solver.SolverB {

    public static DialBuilder with(Stream<String> orders) {
        return new DialBuilder(orders);
    }


    private Dial build() {
        return orders.reduce(Dial.initialize(), DialBuilder::createNewDial, (_, b) -> b);
    }

    private static Dial createNewDial(Dial dial, String s) {
        return Dial.initialize(dial.move(s), updateCount(dial.move(s), dial));
    }

    static int updateCount(int position, Dial dial) {
        return dial.count() + timesInZero(position, dial.position());
    }

    private static int timesInZero(int position, int oldPosition) {
        if (position == 0) return 1;
        if (position < 0) return Math.abs(position) / 100 + (oldPosition == 0 ? 0 : 1);
        return position / 100;
    }

    @Override
    public long solveB() {
        return this.build().count();
    }
}
