package AoC_2025.day02.a;

import java.util.stream.IntStream;

class InvalidIdProvider {

    public static IntStream getInvalidCodes(int min, int max) {
        return IntStream.range(min, max).mapToObj(String::valueOf).mapToInt(InvalidIdProvider::check).filter(i -> i >= 0);
    }

    private static int check(String s) {
        return check(s.substring(s.length() / 2), s.substring(0, s.length() / 2));
    }

    private static int check(String substring, String substring1) {
        if (substring.equals(substring1)) return toInt(substring1);
        return 0;
    }

    private static Integer toInt(String split) {
        return Integer.parseInt(split);
    }

}
