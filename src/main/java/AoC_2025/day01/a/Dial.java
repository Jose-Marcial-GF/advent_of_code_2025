package AoC_2025.day01.a;

public class Dial {
    private final int position;
    private final int count;

    private Dial(int position, int count) {
        this.position = position;
        this.count = count;
    }

    public static Dial create() {
        return new Dial(50, 0);
    }


    public static Dial in(int position, int count) {
        if(isValid(position)){
            return new Dial(position, count);
        }
        return new Dial(validate(position), updateCount(position, count));
    }
    private static boolean isValid(int position) {
        return position < 100 && position >0;
    }

    static int validate(int position) {
        return (position + 100 + 100 * Math.max(1, Math.abs(position) / 100)) % (100);
    }

    static int updateCount(int position, int count) {
        return isEqualZero(position) ? count + 1 : count;
    }

    private static boolean isEqualZero(int position) {
        return Math.abs(position) % 100 == 0;
    }

    public Dial move(String directions) {
        return Dial.in(position + toInt(directions), count);
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
        return this.count;
    }
}
