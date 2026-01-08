package AoC_2025.day06.a;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RangesTest {
    private final String short_example = """
123 328  51 64 \n
 45 64  387 23 \n
  6 98  215 314 \n
*   +   *   +  """;
    private final String sum = """
328  64
64  23 
98          314 
+    +   +""";

    @Test
    public void should_solve_example_case() {
        assertThat(Parser.of(sum).operate()).isEqualTo(891);
        assertThat(Parser.of(short_example).operate()).isEqualTo(4277556);
    }


}
