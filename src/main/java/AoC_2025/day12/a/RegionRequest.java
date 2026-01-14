package AoC_2025.day12.a;

public record RegionRequest(int width, int height, int[] counts) {
    public int area() {
        return width * height;
    }
}
