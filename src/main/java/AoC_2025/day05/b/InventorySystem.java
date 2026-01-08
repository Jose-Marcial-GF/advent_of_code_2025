package AoC_2025.day05.b;

public class InventorySystem {
    public static long solve(String input) {
        String[] sections = input.split("\n\n");

        return new RangeList().add(sections[0]).sort().numbersAvailable();
    }
}

