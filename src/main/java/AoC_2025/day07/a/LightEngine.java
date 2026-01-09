package AoC_2025.day07.a;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

class LightEngine {
    private final List<String> layers;
    private World world;

    public int getResult() {
        layers.forEach(layer -> this.world = world.update(layer));
        return world.appliedReflexions();
    }

    LightEngine(String world) {
        this.layers = Arrays.stream(layersOf(world)).skip(1).toList();
        this.world = new World(getFirstLight(layersOf(world)[0]), 0);
    }

    private static String[] layersOf(String string) {
        return string.split("\n");
    }

    private Set<Integer> getFirstLight(String initialLine) {
        return Set.of(initialLine.indexOf('S'));
    }
}
