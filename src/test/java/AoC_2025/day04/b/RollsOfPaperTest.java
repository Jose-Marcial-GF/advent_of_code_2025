package AoC_2025.day04.b;

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
        long sum = Stream.iterate(Grid.of(short_example_test.lines()), g -> Grid.of(g.grid())).mapToLong(g-> g.detectFewer(4))
                .takeWhile(rollsDetected -> rollsDetected > 0)
                .sum();
        assertThat(sum).isEqualTo(43L);
    }
}
