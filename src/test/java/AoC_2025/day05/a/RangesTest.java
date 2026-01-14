package AoC_2025.day05.a;

import AoC_2025.day05.architecture.InventorySystem;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RangesTest {
    private final String input = """
            3-5
            10-14
            16-20
            12-18
            
            1
            5
            8
            11
            17
            32
            """;

    @Test
    public void main_test() {
        assertThat(Main.main()).isEqualTo(865);
    }

    @Test
    public void should_solve_example_case() {
        assertThat(InventorySystem.with(input.lines()).solveA()).isEqualTo(3);
    }
}

