import java.util.*;

public class MyGraph<T> {
    private final Map<T, Vertex<T>> vertices;
    private final boolean undirected;

    public MyGraph() {
        this(true);
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
        this.vertices = new HashMap<>();
    }

    public void addVertex(T data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(T sourceData, T destData, double weight) {
        Vertex<T> source = vertices.computeIfAbsent(sourceData, Vertex::new);
        Vertex<T> dest = vertices.computeIfAbsent(destData, Vertex::new);

        source.addAdjacentVertex(dest, weight);
        if (undirected) {
            dest.addAdjacentVertex(source, weight);
        }
    }

    public Vertex<T> getVertex(T data) {
        return vertices.get(data);
    }

    public List<Edge<T>> getNeighbors(Vertex<T> v) {
        return v.getAdjacentVertices().entrySet().stream()
                .map(e -> new Edge<>(v, e.getKey(), e.getValue()))
                .toList();
    }
}