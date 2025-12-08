package AoC_2025.day01.a;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DialTest {
    @Test
    public void should_move_given_a_direction() {
        assertThat(snake.move("L1").position()).isEqualto(49);
    }

    public static class snake{

    }
}
