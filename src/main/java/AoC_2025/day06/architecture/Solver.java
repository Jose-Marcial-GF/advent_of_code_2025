package AoC_2025.day06.architecture;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static AoC_2025.Solver.*;

public record Solver (Function<String, Sheet> sheetWith, Function<Sheet, Calculator> calculatorWith, String input)implements SolverB, SolverA {


    public static Solver using(Function<String, Sheet> sheet, Function<Sheet, Calculator> calculator, Stream<String> input){
        return new Solver(sheet, calculator, input.collect(Collectors.joining("\n")));
    }

    @Override
    public long solveA() {
        return calculatorWith.apply(sheetWith.apply(input)).calculateTotal();
    }

    @Override
    public long solveB() {
        return calculatorWith.apply(sheetWith.apply(input)).calculateTotal();
    }
}
