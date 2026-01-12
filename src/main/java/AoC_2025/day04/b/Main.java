package AoC_2025.day04.b;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static Path getPath() {

        return Path.of("src/main/resources/puzzle_input_day_4.txt");
    }

    private static Stream<String> rolls(){
        try {
            return Files.lines(getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    static Long main() {
        return Stream.iterate(Grid.of(rolls()), g -> Grid.of(g.grid())).mapToLong(g -> g.detectFewer(4))
                .takeWhile(rollsDetected -> rollsDetected > 0).sum();
    }
}
