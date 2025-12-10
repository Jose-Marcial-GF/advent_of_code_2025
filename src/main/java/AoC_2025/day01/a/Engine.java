package AoC_2025.day01.a;

import java.util.Arrays;
import java.util.stream.Stream;

public class Engine {

    private final Stream<String> orders;

    private Engine(Stream<String> orders) {
        this.orders = orders;
    }

    public static Engine with(String orders){
        return new Engine(Arrays.stream(orders.split("\n")));
    }

    public Dial start(){
        return orders.reduce(Dial.create(), Engine::ckeck, (a, b) -> b);
    }

    private static Dial ckeck(Dial snake, String s) {
        Dial candidate = snake.move(s);
        if(isValid(candidate.position())){
            return candidate;
        }
        return Dial.in(validate(candidate.position()), upDateLoop(candidate));
    }

    private static boolean isValid(int position) {
        return position < 100 && position >0;
    }

    static int validate(int position) {
        return (position + 100 + 100 * Math.max(1, Math.abs(position) / 100)) % (100);
    }

    static int upDateLoop(Dial snake) {
        return validate(snake.position()) == 0 ? snake.count() + 1 : snake.count();
    }
}
