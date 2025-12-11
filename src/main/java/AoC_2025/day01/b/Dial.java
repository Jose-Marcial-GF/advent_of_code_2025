package AoC_2025.day01.b;

public record Dial(int position, int count) {
    public Dial(int position, int count) {
        this.position = makeValidate(position);
        this.count = count;
    }

    public static Dial create() {
        return new Dial(50, 0);
    }


    public static Dial create(int position, int count) {
        return new Dial(position, count);
    }

    static int makeValidate(int position) {
        return (position + 100 + 100 * Math.max(1, Math.abs(position) / 100)) % (100);
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
