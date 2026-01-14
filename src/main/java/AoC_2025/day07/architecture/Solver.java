package AoC_2025.day07.architecture;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static AoC_2025.Solver.*;

public record Solver(Function<String, World> worldInitialize, List<String> input, Engine engine) implements SolverA, SolverB {
    public static Solver with(Function<String, World> worldInitialize, Stream<String> input){
        return new Solver(worldInitialize, input.toList(), getEngine());
    }


    @Override
    public long solveA() {
        return engine.getReflexions(worldInitialize.apply(input.getFirst()), input.stream().skip(1));
    }

    @Override
    public long solveB() {
        return engine.getReflexions(worldInitialize.apply(input.getFirst()), input.stream().skip(1));
    }

    private static Engine getEngine() {
        return (world, layers) -> layers.reduce(
                world, World::update, (_, newLightWorld) -> newLightWorld
                )
                .getReflexions();
    }
}
