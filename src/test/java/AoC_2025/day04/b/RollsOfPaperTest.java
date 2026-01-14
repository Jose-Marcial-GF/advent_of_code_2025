package AoC_2025.day04.b;

import AoC_2025.day04.architecture.Grid;
import org.junit.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RollsOfPaperTest {
    private final String  short_example_test = "..@@.@@@@.\n" +
            "@@@.@.@.@@\n" +
            "@@@@@.@.@@\n" +
            "@.@@@@..@.\n" +
            "@@.@@@@.@@\n" +
            ".@@@@@@@.@\n" +
            ".@.@.@.@@@\n" +
            "@.@@@.@@@@\n" +
            ".@@@@@@@@.\n" +
            "@.@.@@@.@.";

    @Test
    public void main_test() {
        assertThat(Main.main()).isEqualTo(9173);
    }
    @Test
    public void detect_the_four_rolls_of_paper_arrows_of_13() {
        assertThat(Grid.of(short_example_test.lines()).solveB()).isEqualTo(43L);
    }
}
