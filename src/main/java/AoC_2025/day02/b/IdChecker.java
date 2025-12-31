package AoC_2025.day02.b;

import java.util.Arrays;
import java.util.stream.LongStream;

class IdChecker {
    public static Long getInvalidCodesSum(String s) {
        return Arrays.stream(s.split(",")).mapToLong(s1-> getInvalidCodes(s1.split("-")).sum()).sum();
    }

    private static LongStream getInvalidCodes(String[] split) {
        return InvalidIdProvider.getInvalidCodes(toLong(split[0]), toLong(split[1]));
    }

    private static Long toLong(String split) {
        return Long.parseLong(split);
    }
}

