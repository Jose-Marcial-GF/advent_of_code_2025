package AoC_2025.day02.b;

import java.util.stream.LongStream;

class InvalidIdProvider {

    public static LongStream getInvalidCodes(Long min, Long max) {
        return LongStream.range(min, max + 1).mapToObj(String::valueOf).filter(InvalidIdProvider::isValid).mapToLong(InvalidIdProvider::toLong);
    }

    private static boolean isValid(String s) {
        return s.matches("^(.+)\\1$");
    }

    private static Long toLong(String split) {
        return Long.parseLong(split);
    }

}
