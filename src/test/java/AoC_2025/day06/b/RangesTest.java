package AoC_2025.day06.b;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RangesTest {
    private final String short_example = """
123 328  51 64 \n
 45 64  387 23 \n
  6 98  215 314 \n
*   +   *   +  \s""";

    @Test
    public void should_solve_example_case() {
        assertThat(Parser.of(short_example).operate()).isEqualTo(3263827);
    }


}
