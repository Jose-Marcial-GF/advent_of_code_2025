package AoC_2025.day01.a;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        assertThat(Snake.create().move("L2").position()).isEqualTo(48);
        assertThat(Snake.create().move("R8").position()).isEqualTo(58);
    }

    @Test
    public void should_move_given_more_than_one_direction(){
        assertThat(Snake.create().move("L2").move("L2").position()).isEqualTo(46);
    }



    @Test
    public void should_move_given_a_large_string(){
        assertThat(Snake.create().move(orders).position()).isEqualTo(32);
    }


    @Test
    public void should_count_the_zeros(){
        assertThat(Snake.create().move("L50").count()).isEqualTo(1);
        assertThat(Snake.create().move("R50").count()).isEqualTo(1);
        assertThat(Snake.create().move("R50").move("L100").count()).isEqualTo(1);
    }




    public static class Snake {
        private final int position;
        private final int count;

        private Snake(int position, int count) {
            this.position = validate(position);
            this.count = upDate(count);
        }

        private static int upDate(int count) {
            return count == 0 ? count + 1 : count;
        }

        private int validate(int position) {
            return (position +100) % 100 ;
        }

        public static Snake create(){
            return new Snake(50, 0);
        }

        private static Snake in(int position, int count, Stream<String> movements){
            return new Snake(position, count).move(toString(movements));
        }

        private static Snake in(int position, int count){
            return new Snake(position, count);
        }


        private static String toString(Stream<String> movements) {
            return movements.collect(Collectors.joining("\n"));
        }


        public Snake move(String  directions) {
            if(directions.isEmpty()) return Snake.in(position, count);
            return Snake.in(position + toInt(getFirst(toStream(directions))), count, getRest(toStream(directions)));
        }

        private static String getFirst(Stream<String> directions) {
            return directions.findFirst().orElse("0");
        }

        private Stream<String> getRest(Stream<String> directions) {
            return directions.skip(1);
        }

        private Stream<String> toStream(String direction) {
            return Arrays.stream(direction.split("\n"));
        }

        public int position(){
            return this.position;
        }

        private int toInt(String direction) {
            return Integer.parseInt(
                    direction
                    .replace("L", "-")
                    .replace("R", "+")
            );
        }

        public int count() {
            return this.count;
        }
    }
}
