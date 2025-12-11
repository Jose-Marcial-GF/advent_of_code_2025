package AoC_2025.day01.b;

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
    public void should_move_given_a_direction() {
        assertThat(Dial.create().move("L68")).isEqualTo(-18);
        assertThat(DialBuilder.with("L68").build().position()).isEqualTo(82);
    }

    @Test
    public void should_count_the_zeros(){
        assertThat(DialBuilder.with("L50").build().count()).isEqualTo(1);
        assertThat(DialBuilder.with("R50").build().count()).isEqualTo(1);
        assertThat(DialBuilder.with("L68").build().count()).isEqualTo(1);
    }


    @Test
    public void should_count_the_zeros_given_a_large_string() {

        assertThat(DialBuilder.with("L1000").build().count()).isEqualTo(10);
        assertThat(DialBuilder.with("R1000").build().count()).isEqualTo(10);
        assertThat(DialBuilder.with("R1000").build().position()).isEqualTo(50);
        assertThat(DialBuilder.with("L150\nR150\nL150").build().count()).isEqualTo(5);
        assertThat(DialBuilder.with("L150\nR150\nR150\n200").build().count()).isEqualTo(7);
        assertThat(DialBuilder.with("R150").build().count()).isEqualTo(2);
        assertThat(DialBuilder.with(orders).build().count()).isEqualTo(6);
    }



}
