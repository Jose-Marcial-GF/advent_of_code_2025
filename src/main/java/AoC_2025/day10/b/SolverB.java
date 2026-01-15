package AoC_2025.day10.b;

import AoC_2025.Solver;
import AoC_2025.day10.architecture.Graph;
import AoC_2025.day10.architecture.Operator;
import AoC_2025.day10.architecture.State;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record SolverB(Stream<String> input) implements Solver.SolverB {

    public static Solver.SolverB with(Stream<String > input) {
        return new SolverB(input);
    }

    public AlgorithmSolver getAlgorithm(Graph graph) {
        return new AlgorithmSolver(precomputePatterns(graph.operators(), graph.goalState().size()), new HashMap<>());
    }

    private Map<State, List<Pattern>> precomputePatterns(List<Operator> operators, int size) {

        return IntStream.range(0, combinationsPosible(operators))
                .mapToObj(mask -> createPatternFromMask(mask, operators, size))
                .collect(Collectors.groupingBy(
                        pattern -> pattern.effect().toParity()
                ));
    }

    private static int combinationsPosible(List<Operator> operators) {
        return 1 << operators.size();
    }

    private Pattern createPatternFromMask(int mask, List<Operator> operators, int size) {
        List<Operator> activeOps = IntStream.range(0, operators.size())
                .filter(i -> (mask & (1 << i)) != 0)
                .mapToObj(operators::get)
                .toList();

        return new Pattern(addOperatorsEffects(size, activeOps), activeOps.size());
    }


    private static State addOperatorsEffects(int size, List<Operator> activeOps) {
        return activeOps.stream()
                .reduce(State.initial(size), State::add, (_, s2) -> s2);
    }


    @Override
    public long solveB() {
        return input
                .mapToLong(this::solveLine)
                .sum();
    }

    private long solveLine(String line) {
        return getAlgorithm(GraphBuilder.of(line)).solve(GraphBuilder.of(line).goalState()).orElse(0);
    }
}
