package AoC_2025.day05.a;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class InventorySystem {
    public static long solve(String input) {
        String[] sections = input.split("\n\n");

        return countFreshIngredients(sections[1].lines(), new RangeList(listOfRanges(sections[0].lines())).reduces());
    }

    private static long countFreshIngredients(Stream<String> ingredientId, RangeList rangeList) {
        return ingredientId
                .map(Long::parseLong)
                .filter(rangeList::contains)
                .count();
    }

    private static List<Range> listOfRanges(Stream<String> ranges) {
        return ranges
                .map(InventorySystem::toRange)
                .sorted(Comparator.comparingLong(Range::from))
                .toList();
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

