package AoC_2025.day05.b;

import java.util.Comparator;
import java.util.List;

public class InventorySystem {
    public static long solve(String input) {
        String[] sections = input.split("\n\n");

        return new RangeList(listOfRanges(sections)).reduces().numbersAvailable();
    }

    private static List<Range> listOfRanges(String[] sections) {
        return sections[0].lines().map(InventorySystem::toRange).sorted(Comparator.comparingLong(Range::from)).toList();
    }

    private static Range toRange(String s) {
        return toRange(s.split("-"));
    }

    private static Range toRange(String[] split) {
        return new Range(toLong(split[0]), toLong(split[1]));
    }

    private static Long toLong(String s) {
        return Long.parseLong(s);
    }
}

