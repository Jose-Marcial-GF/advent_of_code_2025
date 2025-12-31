package AoC_2025.day02.a;

import java.util.stream.LongStream;

class InvalidIdProvider {

    public static LongStream getInvalidCodes(Long min, Long max) {
        return LongStream.range(min, max + 1).mapToObj(String::valueOf).filter(InvalidIdProvider::isValid).mapToLong(InvalidIdProvider::toLong).filter(i -> i > 0);
    }

    private static boolean isValid(String s) {
        return isValid(s.substring(s.length() / 2), s.substring(0, s.length() / 2));
    }

    private static boolean isValid(String substring, String substring1) {
        return substring.equals(substring1);
    }

    private static Long toLong(String split) {
        return Long.parseLong(split);
    }

}
