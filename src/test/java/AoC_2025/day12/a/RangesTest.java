package AoC_2025.day12.a;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RangesTest {
    private final String short_example = """
0:
###
##.
##.

1:
###
##.
.##

2:
.##
###
##.

3:
##.
###
##.

4:
###
#..
###

5:
###
.#.
###

4x4: 0 0 0 0 2 0
12x5: 1 0 1 0 2 2
12x5: 1 0 1 0 3 2
""";


    @Test
    public void main_Test() {
        assertThat(Main.main()).isEqualTo(521);
    }

    @Test
    public void should_solve_example_case() {
        assertThat(Solver.with(short_example.lines()).solveA()).isEqualTo(2);
    }


}
