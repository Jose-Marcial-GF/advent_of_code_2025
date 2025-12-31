package AoC_2025.day02.a;

import java.util.stream.IntStream;

class IdChecker {
    public static int getInvalidCodesSum(String s) {
        return getInvalidCodes(s.split("-")).sum();
    }

    private static IntStream getInvalidCodes(String[] split) {
        return InvalidIdProvider.getInvalidCodes(toInt(split[0]), toInt(split[1]));
    }

    private static Integer toInt(String split) {
        return Integer.parseInt(split);
    }
}

