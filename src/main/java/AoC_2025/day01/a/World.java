package AoC_2025.day01.a;

import java.util.Arrays;
import java.util.stream.Stream;

public class World {

    private final Stream<String> orders;

    private World(Stream<String> orders) {
        this.orders = orders;
    }

    public static World with(String orders){
        return new World(Arrays.stream(orders.split("\n")));
    }

    public Snake start(){
        return orders.reduce(Snake.create(), World::ckeck, (a, b) -> b);
    }

    private static Snake ckeck(Snake snake, String s) {
        Snake candidate = snake.move(s);
        if(isValid(candidate.position())){
            return candidate;
        }
        return Snake.in(validate(candidate.position()), upDateLoop(candidate));
    }

    private static boolean isValid(int position) {
        return position < 100 && position >0;
    }

    static int validate(int position) {
        return (position + 100 + 100 * Math.max(1, Math.abs(position) / 100)) % (100);
    }

    static int upDateLoop(Snake snake) {
        return validate(snake.position()) == 0 ? snake.count() + 1 : snake.count();
    }
}
