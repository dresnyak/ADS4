import java.util.*;

public class DepthFirstSearch<T> extends Search<T> {
    public DepthFirstSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(WeightedGraph<T> graph, Vertex<T> current) {
        marked.add(current);
        System.out.println("Visited: " + current);

        for (Edge<T> edge : graph.getNeighbors(current)) {
            Vertex<T> neighbor = edge.getDest();
            if (!marked.contains(neighbor)) {
                edgeTo.put(neighbor, current);
                dfs(graph, neighbor);
            }
        }
    }

    @Override
    public void search() {
        // DFS is executed in the constructor
    }
}