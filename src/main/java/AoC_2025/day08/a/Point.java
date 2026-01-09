package AoC_2025.day08.a;

public record Point(int x, int y, int z) {

    public static Point of(String[] split) {
        return new Point(toInt(split[0]),toInt(split[1]),toInt(split[2]));
    }

    private static int toInt(String s) {
        return Integer.parseInt(s.trim());
    }
}
