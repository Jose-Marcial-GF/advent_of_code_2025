package AoC_2025.day12.a;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
        private static Path getPath() {

            return Path.of("src/main/resources/puzzle_input_day_12.txt");
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
            InputParser parser = InputParser.with(getProblem());
            PuzzleSolver solver = new PuzzleSolver();

            return parser.getRequests().stream().mapToInt(regionRequest -> solver.solve(regionRequest, parser.getShapes())).sum();
        }


    }