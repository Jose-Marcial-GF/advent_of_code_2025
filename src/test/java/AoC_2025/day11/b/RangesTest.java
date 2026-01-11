package AoC_2025.day11.b;

import org.junit.Test;

public class RangesTest {
    private final String short_example = """
svr: aaa bbb
aaa: fft
fft: ccc
bbb: tty
tty: ccc
ccc: ddd eee
ddd: hub
hub: fff
eee: dac
dac: fff
fff: ggg hhh
ggg: out
hhh: out
    """;

    @Test
    public void should_solve_example_case() {
        DeviceGraph network = GraphBuilder.of(short_example).build();
        System.out.println(PathFinder.solvePart2(network, "svr", "out"));
        System.out.println(Main.main());

    }


}
