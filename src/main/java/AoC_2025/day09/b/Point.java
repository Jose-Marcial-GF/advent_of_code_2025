package AoC_2025.day09.b;

public record Point(Long x, Long y) {

    public static Point of(String[] split) {
        return new Point(toLong(split[0]), toLong(split[1]));
    }

    private static long toLong(String s) {
        return Long.parseLong(s.trim());
    }
}
