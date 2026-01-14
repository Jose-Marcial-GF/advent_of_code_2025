package AoC_2025.day05.b;


import AoC_2025.day05.architecture.InventorySystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {
    private static Path getPath() {

        return Path.of("src/main/resources/puzzle_input_day_5.txt");
    }

    private static Stream<String> getPuzzleInput(){
        try {
            return Files.lines(getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Long main() {
        return InventorySystem.with(getPuzzleInput()).solveB();
    }
}