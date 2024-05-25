import java.util.*;

public class WeightedGraph<T> {
    private final boolean undirected;
    private final Map<Vertex<T>, List<Edge<T>>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex<T> v) {
        map.putIfAbsent(v, new LinkedList<>());
    }

    public void addEdge(Vertex<T> source, Vertex<T> dest, double weight) {
        addVertex(source);
        addVertex(dest);

        map.get(source).add(new Edge<>(source, dest, weight));
        if (undirected) {
            map.get(dest).add(new Edge<>(dest, source, weight));
        }
    }

    public List<Edge<T>> getNeighbors(Vertex<T> v) {
        return map.get(v);
    }
}