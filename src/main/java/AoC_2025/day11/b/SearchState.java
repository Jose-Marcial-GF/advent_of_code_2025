package AoC_2025.day11.b;

record SearchState(String node, boolean visitedDac, boolean visitedFft) {

    public static SearchState next(String currentNode, boolean visitedDac, boolean visitedFft){
        return new SearchState(currentNode, visitedDac|| currentNode.equals("dac"), visitedFft|| currentNode.equals("fft"));
    }
}
