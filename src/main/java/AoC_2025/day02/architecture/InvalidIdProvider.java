package AoC_2025.day02.architecture;

import java.util.function.Function;
import java.util.stream.LongStream;

class InvalidIdProvider {


    public static LongStream getInvalidCodes(Long min, Long max, Function<String, Boolean> validate) {
        return LongStream.range(min, max + 1)
                .mapToObj(String::valueOf)
                .filter(validate::apply)
                .mapToLong(InvalidIdProvider::toLong);
    }

    private static Long toLong(String split) {
        return Long.parseLong(split);
    }
}
