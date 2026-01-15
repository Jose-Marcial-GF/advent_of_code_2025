package AoC_2025.day10.a;

import AoC_2025.day10.architecture.Graph;
import AoC_2025.day10.architecture.State;

import java.util.*;
import java.util.stream.Stream;

public record Solver(Stream<String> input) implements AoC_2025.Solver.SolverA {

    public static Solver with(Stream<String> input){
        return new Solver(input);
    }

    @Override
    public long solveA() {
        return input.mapToLong(s -> getShortestPath(GraphBuilder.of(s))).sum();
    }


    public long getShortestPath(Graph graph) {
        return bfs(initialState(graph), OpenQueue(), Visited(), graph);
    }


    private long bfs(State startState, Queue<SearchNode> openQueue, Set<State> visited, Graph graph) {

        SearchNode root = new SearchNode(startState, null);
        openQueue.add(root);
        visited.add(startState);

        return whileNotEmpty(openQueue)
                .peek(currentNode-> expand(currentNode, openQueue, visited, graph))
                .filter(node -> node.state().equals(graph.goalState()))
                .map(SearchNode::getDepth)
                .findFirst()
                .orElse(0L);

    }

    private static Stream<SearchNode> whileNotEmpty(Queue<SearchNode> openQueue) {
        return Stream.generate(openQueue::poll)
                .takeWhile(Objects::nonNull);
    }

    private void expand(SearchNode currentNode, Queue<SearchNode> openQueue, Set<State> visited, Graph graph) {
        graph.operators().stream().map(
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

    private State initialState(Graph graph) {
        return State.initial(graph.goalState().size());
    }
}
