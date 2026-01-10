package AoC_2025.day09.a;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RangesTest {
    private final String short_example = """
                7,1
                11,1
                11,7
                9,7
                9,5
                2,5
                2,3
                7,3
    """;

    @Test
    public void should_solve_example_case() {
        assertThat(RectangleFinder.with(short_example).findLargestRectangle().area()).isEqualTo(50);
    }


}
