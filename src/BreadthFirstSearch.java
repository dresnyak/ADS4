import java.util.*;

public class BreadthFirstSearch<T> extends Search<T> {
    public BreadthFirstSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<T> graph, Vertex<T> current) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        marked.add(current);
        queue.add(current);

        while (!queue.isEmpty()) {
            Vertex<T> v = queue.poll();
            System.out.println("Visited: " + v);

            for (Edge<T> edge : graph.getNeighbors(v)) {
                Vertex<T> neighbor = edge.getDest();
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, v);
                    queue.add(neighbor);
                }
            }
        }
    }
}
