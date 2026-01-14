package AoC_2025.day10.a;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
        private static Path getPath() {

            return Path.of("src/main/resources/puzzle_input_day_10.txt");
        }

        private static Stream<String> getPuzzleInput(){
            try {
                return Files.lines(getPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        public static long main() {
            return getPuzzleInput().mapToLong(s -> GraphBuilder.of(s).getShortestPath()).sum();
        }


    }