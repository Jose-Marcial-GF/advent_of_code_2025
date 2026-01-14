package AoC_2025.day07.a;

import java.util.List;
import java.util.Set;

record LightEngine(World world, List<String> layers) {

    public static LightEngine build(String world) {
        return new LightEngine(new World(initialLightPosition(world), 0), restOfLayers(world));
    }

    public int getAppliedReflexions() {
        return layers.stream()
                .reduce(world, World::update, (oldWorld, newWorld) -> newWorld)
                .appliedReflexions();
    }


    private static List<String> restOfLayers(String world) {
        return world.lines().skip(1).toList();
    }

    private static String getFirstLayer(String string) {
        return string.lines().findFirst().orElse("");
    }

    private static Set<Integer> initialLightPosition(String world) {
        return Set.of(getFirstLayer(world).indexOf('S'));
    }
}
