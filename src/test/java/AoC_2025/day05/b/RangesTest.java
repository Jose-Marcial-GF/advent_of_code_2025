package AoC_2025.day05.b;

import AoC_2025.day05.architecture.InventorySystem;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RangesTest {
    private final String input = """
            3-5
            10-14
            16-20
            12-18
            """;

    @Test
    public void main_test() {
        assertThat(Main.main()).isEqualTo(352556672963116L);
    }

    @Test
    public void should_solve_example_case() {
        assertThat(InventorySystem.with(input.lines()).solveB()).isEqualTo(14);
    }
}
