package AoC_2025.day01.a;

public class Dial {
    private final int position;
    private final int loops;

    private Dial(int position, int loops) {
        this.position = position;
        this.loops = loops;
    }

    public static Dial create() {
        return new Dial(50, 0);
    }


    public static Dial in(int position, int loops) {
        return new Dial(position, loops);
    }

    public Dial move(String directions) {
        return Dial.in(position + toInt(directions), loops);
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
