package AoC_2025.day01.architecture;

public record Dial(int position, int count) {
    public Dial(int position, int count) {
        this.position = makeValidate(position);
        this.count = count;
    }

    public static Dial initialize() {
        return new Dial(50, 0);
    }


    public static Dial initialize(int position, int count) {
        return new Dial(position, count);
    }

    static int makeValidate(int position) {
        return ((position % 100) + 100) % 100;
    }

    public int move(String directions) {
        return position + toInt(directions);
    }

    private int toInt(String direction) {
        return Integer.parseInt(
                direction
                        .replace("L", "-")
                        .replace("R", "+")
        );
    }
}
