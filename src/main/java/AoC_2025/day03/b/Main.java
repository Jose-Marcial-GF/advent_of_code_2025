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

    private static Stream<String> voltages(){
        try {
            return Files.lines(getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Long main() {
        return BatteryBuilder.lookingFor(12).from(voltages()).sum();
    }
}
