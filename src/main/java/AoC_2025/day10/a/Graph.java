package AoC_2025.day10.a;

import java.util.*;
import java.util.stream.Stream;

public record Graph(List<Operator> operators, State goalState) {

    public long getShortestPath() {
        return bfs(initialState(), OpenQueue(), Visited());
    }


    private long bfs(State startState, Queue<SearchNode> openQueue, Set<State> visited) {

        SearchNode root = new SearchNode(startState, null);
        openQueue.add(root);
        visited.add(startState);

        return whileNotEmpty(openQueue)
                .peek(currentNode-> expand(currentNode, openQueue, visited))
                .filter(node -> node.state().equals(goalState))
                .map(SearchNode::getDepth)
                .findFirst()
                .orElse(0L);

    }

    private static Stream<SearchNode> whileNotEmpty(Queue<SearchNode> openQueue) {
        return Stream.generate(openQueue::poll)
                .takeWhile(Objects::nonNull);
    }

    private void expand(SearchNode currentNode, Queue<SearchNode> openQueue, Set<State> visited) {
        operators.stream().map(
                operator -> currentNode.state().apply(operator))
                .filter(state-> addIfNew(visited, state))
                .map(state -> new SearchNode(state, currentNode))
                .forEach(openQueue::add);
    }

    private boolean addIfNew(Set<State> visited, State state) {
        return visited.add(state);
    }
    private static HashSet<State> Visited() {
        return new HashSet<>();
    }

    private static LinkedList<SearchNode> OpenQueue() {
        return new LinkedList<>();
    }

    private State initialState() {
        return State.initial(goalState.size());
    }

}
