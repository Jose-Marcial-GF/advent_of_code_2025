package AoC_2025.day07.a;

import AoC_2025.day07.architecture.World;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record LightWorld(Set<Integer> lights, int appliedReflexions) implements World {

    private static Set<Integer> splinterSet(String layer) {
        return IntStream.range(0, layer.length())
                .filter(i -> layer.charAt(i) == '^')
                .boxed().collect(Collectors.toSet());
    }

    public static World initialize(String firstLine){
        return new LightWorld(Set.of(firstLine.indexOf('S')), 0);
    }

    public LightWorld update(String layer) {
        return update(splinterSet(layer));
    }

    @Override
    public Long getReflexions() {
        return (long) appliedReflexions;
    }

    private LightWorld update(Set<Integer> layer) {
        return new LightWorld(applyReflexionIn(layer), getNewReflexionIndex(layer) + appliedReflexions);
    }

    private int getNewReflexionIndex(Set<Integer> lightSet) {
        return (int) lightSet.stream().filter(lights::contains).count();
    }

    private Set<Integer> applyReflexionIn(Set<Integer> lightSet) {
        return lights.stream().flatMap(i -> lightSet.contains(i) ? Stream.of(i-1, i+1) : Stream.of(i)).collect(Collectors.toSet());
    }

}
