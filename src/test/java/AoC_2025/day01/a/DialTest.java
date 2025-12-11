package AoC_2025.day01.a;

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
        assertThat(Dial.create().move("L2").position()).isEqualTo(48);
        assertThat(Dial.create().move("R8").position()).isEqualTo(58);
    }

    @Test
    public void should_move_given_more_than_one_direction(){
        assertThat(Dial.create().move("L2").move("L2").position()).isEqualTo(46);
    }



    @Test
    public void should_move_given_a_large_string(){
        assertThat(DialBuilder.with(orders).build().position()).isEqualTo(32);
    }


    @Test
    public void should_count_the_zeros(){
        assertThat(DialBuilder.with("L50").build().count()).isEqualTo(1);
        assertThat(DialBuilder.with("R50").build().count()).isEqualTo(1);
        assertThat(DialBuilder.with("R50\nL1200").build().count()).isEqualTo(2);
    }


    @Test
    public void should_count_the_zeros_given_a_large_string() {
        assertThat(DialBuilder.with(orders).build().count()).isEqualTo(3);
    }



}
