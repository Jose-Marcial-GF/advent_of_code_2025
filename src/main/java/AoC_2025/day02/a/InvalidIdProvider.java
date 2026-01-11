package AoC_2025.day02.a;

import java.util.stream.LongStream;

class InvalidIdProvider {

    public static LongStream getInvalidCodes(Long min, Long max) {
        return LongStream.range(min, max + 1)
                .mapToObj(String::valueOf)
                .filter(InvalidIdProvider::isInvalid)
                .mapToLong(InvalidIdProvider::toLong);
    }

    private static boolean isInvalid(String number) {
        return isInvalid(number.substring(number.length() / 2), number.substring(0, number.length() / 2));
    }

    private static boolean isInvalid(String substring, String substring1) {
        return substring.equals(substring1);
    }

    private static Long toLong(String split) {
        return Long.parseLong(split);
    }

}
