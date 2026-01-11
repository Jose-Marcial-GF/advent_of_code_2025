package AoC_2025.day02.b;

import java.util.Arrays;
import java.util.stream.LongStream;

class IdChecker {
    public static Long getInvalidCodesSum(String ranges) {
        return Arrays.stream(ranges.split(",")).mapToLong(range-> getInvalidCodes(range.split("-")).sum()).sum();
    }

    private static LongStream getInvalidCodes(String[] range) {
        return InvalidIdProvider.getInvalidCodes(toLong(range[0]), toLong(range[1]));
    }

    private static Long toLong(String split) {
        return Long.parseLong(split);
    }
}

