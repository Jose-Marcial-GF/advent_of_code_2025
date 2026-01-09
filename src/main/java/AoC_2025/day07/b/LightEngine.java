package AoC_2025.day07.b;

import java.util.Arrays;
import java.util.List;

class LightEngine {
    private final List<String> layers;
    private World world;

    public long getResult() {
        layers.forEach(layer -> this.world = world.update(layer));
        return world.getTotalTimelines();
    }

    LightEngine(String world) {
        this.layers = Arrays.stream(layersOf(world)).skip(1).toList();
        this.world = new World(getFirstLight(layersOf(world)[0]));
    }

    private static String[] layersOf(String string) {
        return string.split("\n");
    }

    private Integer getFirstLight(String initialLine) {
        return initialLine.indexOf('S');
    }
}
