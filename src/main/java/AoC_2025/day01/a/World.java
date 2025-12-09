package AoC_2025.day01.a;

import java.util.Arrays;

public class World {

    private final Snake snake;
    private final String[] orders;

    public World(Snake snake,String orders) {
        this.snake = snake;
        this.orders = orders.split("\n");
    }
}
