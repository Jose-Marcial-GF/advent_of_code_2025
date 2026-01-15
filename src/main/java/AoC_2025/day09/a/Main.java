package AoC_2025.day09.a;

import AoC_2025.day09.architecture.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {
        private static Path getPath() {

            return Path.of("src/main/resources/puzzle_input_day_9.txt");
        }

        private static Stream<String> getPoints(){
            try {
                return Files.lines(getPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        static long main() {
            return RectangleFinder.with(getPoints()).solveA();
        }


    }