package AoC_2025.day01.a;

import AoC_2025.day01.architecture.Dial;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DialTest {

    private static final String orders = """
            L68
            L30
            R48
            L5
            R60
            L55
            L1
            L99
            R14
            L82
            """;



    @Test
    public void main_test() {
        assertThat(Main.main()).isEqualTo(1165);
    }


    @Test
    public void should_move_given_a_direction() {
        assertThat(Dial.initialize().move("L2")).isEqualTo(48);
        assertThat(Dial.initialize().move("R8")).isEqualTo(58);
    }

    @Test
    public void should_count_the_zeros_given_a_large_string() {
        assertThat(DialBuilder.with(orders.lines()).solveA()).isEqualTo(3);
    }



}
