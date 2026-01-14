package AoC_2025.day01.a;


import AoC_2025.Solver;
import AoC_2025.day01.architecture.Dial;

import java.util.stream.Stream;

public record DialBuilder (Stream<String> orders) implements Solver.SolverA {

    public static DialBuilder with(Stream<String> orders) {
        return new DialBuilder(orders);
    }

    private Dial build() {
        return orders.reduce(Dial.initialize(), DialBuilder::createNewDial, (_, b) -> b);
    }

    private static Dial createNewDial(Dial dial, String s) {
        return Dial.initialize(dial.move(s), updateCount(dial.move(s), dial.count()));
    }

    static int updateCount(int position, int count) {
        return count + sumIfRequire(position);
    }

    private static int sumIfRequire(int position) {
        return position % 100 == 0 ? 1 : 0;
    }

    @Override
    public long solveA() {
        return  this.build().count();
    }
}