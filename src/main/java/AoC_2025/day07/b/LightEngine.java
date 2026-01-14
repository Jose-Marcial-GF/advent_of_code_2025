package AoC_2025.day07.b;

import java.util.*;

record LightEngine(World world, List<String> layers) {

    public static LightEngine build(String world) {
        return new LightEngine(new World(getFirstLightPosition(world)), restOfLayers(world));
    }



    public long getResult() {
        return layers.stream().
                reduce(world, World::update, (oldWorld, newWorld) -> newWorld)
                .getTotalTimelines();
    }

    private static List<String> restOfLayers(String world) {
        return world.lines().skip(1).toList();
    }

    private static String getFirstLayer(String string) {
        return string.lines().findFirst().orElse("");
    }


    private static Map<Integer, Long> getFirstLightPosition(String world) {
        return Map.of(getFirstLayer(world).indexOf('S'), 1L);
    }
}
