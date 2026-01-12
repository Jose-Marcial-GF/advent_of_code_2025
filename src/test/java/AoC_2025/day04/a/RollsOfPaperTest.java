package AoC_2025.day04.a;

import org.junit.Test;

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
        assertThat(Main.main()).isEqualTo(1626);
    }
    @Test
    public void detect_the_four_rolls_of_paper_arrows_of_13() {

        assertThat(Grid.of(short_example_test.lines()).detectFewer(4)).isEqualTo(13);
    }
}
