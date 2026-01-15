package AoC_2025.day06.a;



import AoC_2025.day06.architecture.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {
        private static Path getPath() {

            return Path.of("src/main/resources/puzzle_input_day_6.txt");
        }

        private static Stream<String> getPuzzleInput(){
            try {
                return Files.lines(getPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        static long main() {
            return Solver.using(HorizontalMathWorkSheet::of, HorizontalCalculator::with, getPuzzleInput()).solveA();
        }
    }