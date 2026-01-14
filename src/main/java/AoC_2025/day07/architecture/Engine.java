package AoC_2025.day07.architecture;

import java.util.stream.Stream;

public interface Engine {
    long getReflexions(World world, Stream<String> layers);
}
