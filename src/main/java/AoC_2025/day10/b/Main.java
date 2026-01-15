package AoC_2025.day10.b;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {
    private static Path getPath() {
        return Path.of("src/main/resources/puzzle_input_day_10.txt");
    }

    private static Stream<String> getPuzzleInput() {
        try {
            return Files.lines(getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long main() {
        return SolverB.with(getPuzzleInput()).solveB();
    }
}