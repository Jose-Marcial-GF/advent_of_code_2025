package AoC_2025.day03.b;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static Path getPath() {

        return Path.of("src/main/resources/puzzle_input_day_3.txt");
    }

    private static Stream<String> getPuzzleInput(){
        try {
            return Files.lines(getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String voltages() {
        return getPuzzleInput().collect(Collectors.joining("\n"));
    }

    static void main() {
        BatteryBuilder length = BatteryBuilder.length(12);
        System.out.println(length.with(voltages()));
    }
}
