package AoC_2025.day02.architecture;


import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static AoC_2025.Solver.*;

public class IdChecker implements SolverA, SolverB {
    private static final Pattern PATTERN_A = Pattern.compile("^(.+)\\1$");
    private static final Pattern PATTERN_B = Pattern.compile("^(.+)\\1+$");
    private final String ranges;

    public IdChecker(String ranges) {
        this.ranges = ranges;
    }

    public Long getInvalidCodesSum(Pattern pattern) {
        return Arrays.stream(ranges.split(",")).mapToLong(range-> getInvalidCodes(range.split("-"), pattern).sum()).sum();
    }

    private static LongStream getInvalidCodes(String[] range, Pattern pattern) {
        return InvalidIdProvider.getInvalidCodes(toLong(range[0]), toLong(range[1]), string -> pattern.matcher(string).matches());
    }

    private static Long toLong(String split) {
        return Long.parseLong(split);
    }

    public static IdChecker with(Stream<String> ids) {
        return new IdChecker(ids.collect(Collectors.joining()));
    }

    @Override
    public long solveA() {
        return getInvalidCodesSum(PATTERN_A);
    }

    @Override
    public long solveB() {
        return getInvalidCodesSum(PATTERN_B);
    }
}

