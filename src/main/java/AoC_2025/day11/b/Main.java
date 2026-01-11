package AoC_2025.day11.b;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
        private static Path getPath() {

            return Path.of("src/main/resources/puzzle_input_day_11.txt");
        }

        private static Stream<String> getPuzzleInput(){
            try {
                return Files.lines(getPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private static String getProblem() {
            return getPuzzleInput().collect(Collectors.joining("\n"));
        }

        public static long main() {
            DeviceGraph build = GraphBuilder.of(getProblem()).build();
            return PathFinder.solvePart2(build, "svr", "out");
        }


    }