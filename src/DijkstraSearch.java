import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private final Map<Vertex<T>, Double> distances;
    private final WeightedGraph<T> graph;

    public DijkstraSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        this.graph = graph;
        this.distances = new HashMap<>();
        dijkstra();
    }

    private void dijkstra() {
        distances.put(source, 0.0);
        PriorityQueue<Vertex<T>> priorityQueue = new PriorityQueue<>(Comparator.comparing(distances::get));
        priorityQueue.add(source);

        while (!priorityQueue.isEmpty()) {
            Vertex<T> current = priorityQueue.poll();

            for (Edge<T> edge : graph.getNeighbors(current)) {
                Vertex<T> neighbor = edge.getDest();
                double newDist = distances.get(current) + edge.getWeight();

                if (newDist < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            }
        }
    }

    public double getDistance(Vertex<T> target) {
        return distances.getOrDefault(target, Double.POSITIVE_INFINITY);
    }

    @Override
    public void search() {
        // Dijkstra is executed in the constructor
    }
}