package AoC_2025.day12.a;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Solver(String input) implements AoC_2025.Solver.SolverA {

    public static Solver with(Stream<String> stringStream){
        return new Solver(stringStream.collect(Collectors.joining("\n")));
    }

    @Override
    public long solveA() {
        InputParser parser = InputParser.with(input);
        PuzzleSolver solver = new PuzzleSolver();

        return parser.getRequests().stream().mapToInt(regionRequest -> solver.solve(regionRequest, parser.getShapes())).sum();

    }
}
