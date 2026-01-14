package AoC_2025.day12.a;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public void should_solve_example_case() {
        InputParser parser = InputParser.with(short_example);
        PuzzleSolver solver = new PuzzleSolver();


        System.out.println(parser.getRequests().stream().mapToInt(regionRequest -> solver.solve(regionRequest, parser.getShapes())).sum());
    }
    @Test
    public void main() {
        System.out.println(Main.main());
    }


}
