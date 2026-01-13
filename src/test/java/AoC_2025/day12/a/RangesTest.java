package AoC_2025.day12.a;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RangesTest {
    private final String short_example = """
0:
###
##.
##.

1:
###
##.
.##

2:
.##
###
##.

3:
##.
###
##.

4:
###
#..
###

5:
###
.#.
###

4x4: 0 0 0 0 2 0
12x5: 1 0 1 0 2 2
12x5: 1 0 1 0 3 2
""";

    @Test
    public void should_solve_example_case() {
        InputParser parser = InputParser.with(short_example);
        System.out.println(parser.getRequests());
        System.out.println(parser.getShapes());
        PuzzleSolver solver = new PuzzleSolver();

        System.out.println(parser.getRequests().stream().filter(req -> {
            // Convertimos el array de cantidades en una lista plana de Shapes usando Streams
            List<Shape> requiredShapes = IntStream.range(0, req.counts().length)
                    .boxed()
                    .flatMap(i -> Collections.nCopies(req.counts()[i], parser.getShapes().get(i)).stream())
                    .sorted(Comparator.comparingInt(Shape::getArea).reversed()) // Priorizar piezas grandes
                    .collect(Collectors.toList());

            // Validación rápida de área antes de ejecutar el algoritmo pesado
            int totalArea = requiredShapes.stream().mapToInt(Shape::getArea).sum();
            if (totalArea > req.width() * req.height()) return false;

            return solver.canFit(new Region(req.width(), req.height()), requiredShapes);
        }).count());
    }
    @Test
    public void main() {
        System.out.println(Main.main());
    }


}
