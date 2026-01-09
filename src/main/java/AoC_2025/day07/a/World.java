package AoC_2025.day07.a;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record World(Set<Integer> lights, int appliedReflexions) {

    private static Set<Integer> splinterSet(String layer) {
        return IntStream.range(0, layer.length())
                .filter(i -> layer.charAt(i) == '^')
                .boxed().collect(Collectors.toSet());
    }

    public World update(String layer) {
        return update(splinterSet(layer));
    }

    private World update(Set<Integer> layer) {
        return new World(applyReflexionIn(layer), getNewReflexionIndex(layer) + appliedReflexions);
    }

    private int getNewReflexionIndex(Set<Integer> lightSet) {
        return (int) lightSet.stream().filter(lights::contains).count();
    }

    private Set<Integer> applyReflexionIn(Set<Integer> lightSet) {
        return lights.stream().flatMap(i -> lightSet.contains(i) ? Stream.of(i-1, i+1) : Stream.of(i)).collect(Collectors.toSet());
    }

}
