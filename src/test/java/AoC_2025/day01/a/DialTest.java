package AoC_2025.day01.a;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DialTest {
    @Test
    public void should_move_given_a_direction() {
        assertThat(Snake.create().move("L2")).isEqualTo(48);
        assertThat(Snake.create().move("R8")).isEqualTo(58);
    }

    public void should_move_given_more_than_one_direction(){
        assertThat(Snake.create().move("L2").move("L2").positon).isEqualTo(46);
    }

    public static class Snake {
        private final int position;

        private Snake(int position) {
            this.position = position;
        }

        private static Snake create(){
            return new Snake(50);
        }

        public int move(String direction) {
            return position + toInt(direction);
        }

        private int toInt(String direction) {
            return Integer.parseInt(
                    direction
                    .replaceAll("L", "-")
                    .replaceAll("R", "+")
            );
        }
    }
}
