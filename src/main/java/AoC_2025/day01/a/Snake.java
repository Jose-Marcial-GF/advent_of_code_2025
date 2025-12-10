package AoC_2025.day01.a;

public class Snake {
    private final int position;
    private final int loops;

    private Snake(int position, int loops) {
        this.position = position;
        this.loops = loops;
    }

    public static Snake create() {
        return new Snake(50, 0);
    }


    public static Snake in(int position, int loops) {
        return new Snake(position, loops);
    }

    public Snake move(String directions) {
        return Snake.in(position + toInt(directions), loops);
    }

    public int position() {
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
        return this.loops;
    }
}
