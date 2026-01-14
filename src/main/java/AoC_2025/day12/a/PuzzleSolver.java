package AoC_2025.day12.a;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class PuzzleSolver {
    public boolean canFit(Region region, List<Shape> pendingShapes) {
        // S - Single Responsibility: Solo decide si la lista de piezas cabe.
        if (pendingShapes.isEmpty()) return true;

        // Tomamos siempre la primera pieza de la lista para colocarla
        Shape current = pendingShapes.getLast();
        List<Shape> remaining = pendingShapes.subList(0, pendingShapes.size()-1);

        // Probamos todas las variantes de la pieza actual
        return current.getVariants().stream().anyMatch(variant ->
                // Probamos TODAS las coordenadas (x, y) del mapa
                IntStream.range(0, region.height()).anyMatch(y ->
                        IntStream.range(0, region.width()).anyMatch(x -> {
                            if (region.canPlace(variant, x, y)) {
                                region.place(variant, x, y);
                                // Llamada recursiva con el resto de piezas
                                if (canFit(region, remaining)) return true;
                                region.remove(variant, x, y); // Backtrack
                            }
                            return false;
                        })
                )
        );
    }

    public int solve(RegionRequest regionRequest, List<Shape> shapes) {

        List<Shape> requiredShapes = shapes.stream().sorted(Comparator.comparingInt(Shape::getArea))
                .flatMap(shape -> Collections.nCopies(regionRequest.counts()[shapes.indexOf(shape)], shape).stream()).toList();

        if (requiredShapes.stream().mapToInt(Shape::getArea).sum() < regionRequest.area() && canFit(new Region(regionRequest.width(), regionRequest.height()), requiredShapes)) return 1;
        return 0;
    }
}