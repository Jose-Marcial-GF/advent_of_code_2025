package AoC_2025.day01.a;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DialTest {
    @Test
    public void should_move_given_a_direction() {
        assertThat(Snake.create().move("L2").position()).isEqualTo(48);
        assertThat(Snake.create().move("R8").position()).isEqualTo(58);
    }

    @Test
    public void should_move_given_more_than_one_direction(){
        assertThat(Snake.create().move("L2").move("L2").position()).isEqualTo(46);
    }


    @Test
    public void should_move_given_a_stream_of_direction(){
        assertThat(Snake.create().move("L2").move("L2").position()).isEqualTo(46);
    }

    public static class Snake {
        private final int position;

        private Snake(int position) {
            this.position = position;
        }

        public static Snake create(){
            return new Snake(50);
        }

        private static Snake in(int position){
            return new Snake(position);
        }

        public Snake move(String direction) {
            return Snake.in(position + toInt(direction));
        }

        public int position(){
            return this.position;
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
