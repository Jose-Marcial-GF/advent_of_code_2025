package AoC_2025.day11.a;

import AoC_2025.day11.architecture.GraphBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReactorTest {
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
        assertThat(PathFinder.with(GraphBuilder.of(short_example).build()).solve("you", "out")).isEqualTo(5L);

    }
    @Test
    public void main_test() {
        assertThat(Main.main()).isEqualTo(690L);
    }


}
