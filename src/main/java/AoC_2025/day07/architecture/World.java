package AoC_2025.day07.architecture;

public interface World {
    World update(String newLayer);
    Long getReflexions();
}
