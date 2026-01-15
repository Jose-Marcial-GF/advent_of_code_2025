package AoC_2025.day11.b;

import AoC_2025.day11.architecture.GraphBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReactorTest {
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
        assertThat(PathFinder.with(GraphBuilder.of(short_example).build()).solve("svr", "out")).isEqualTo(2L);

    }
    @Test
    public void main_test() {
        assertThat(Main.main()).isEqualTo(557332758684000L);
    }
}
