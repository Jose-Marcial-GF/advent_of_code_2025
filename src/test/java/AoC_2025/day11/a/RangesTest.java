package AoC_2025.day11.a;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RangesTest {
    private final String short_example = """
aaa: you hhh
you: bbb ccc
bbb: ddd eee
ccc: ddd eee fff
ddd: ggg
eee: out
fff: out
ggg: out
hhh: ccc fff iii
iii: out
    """;

    @Test
    public void should_solve_example_case() {
        DeviceGraph network = GraphBuilder.of(short_example).build();
        long totalPaths = PathFinder.countAllPaths(network, "you", "out", new HashMap<>());
        System.out.println("Total de rutas posibles: " + totalPaths);

        System.out.println(Main.main());

    }


}
