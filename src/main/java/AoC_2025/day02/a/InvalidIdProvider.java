package AoC_2025.day02.a;

import java.util.stream.LongStream;

class InvalidIdProvider {

    public static LongStream getInvalidCodes(Long min, Long max) {
        return LongStream.range(min, max + 1).mapToObj(String::valueOf).mapToLong(InvalidIdProvider::check).filter(i -> i > 0);
    }

    private static Long check(String s) {
        return check(s.substring(s.length() / 2), s.substring(0, s.length() / 2));
    }

    private static Long check(String substring, String substring1) {
        if (substring.equals(substring1)) return toInt(substring + substring1);
        return 0L;
    }

    private static Long toInt(String split) {
        return Long.parseLong(split);
    }

}
