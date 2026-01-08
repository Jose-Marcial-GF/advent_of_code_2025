package AoC_2025.day05.a;

import java.util.Arrays;

public class InventorySystem {
    public static long solve(String input) {
        String[] sections = input.split("\n\n");

        RangeList rangeList = new RangeList().add(sections[0]).sort();

        return Arrays.stream(sections[1].split("\n"))
                .map(Long::parseLong)
                .filter(rangeList::contains)
                .count();
    }
}

