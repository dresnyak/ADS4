public class Edge<T> {
    private final Vertex<T> source;
    private final Vertex<T> dest;
    private final double weight;

    public Edge(Vertex<T> source, Vertex<T> dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Vertex<T> getSource() {
        return source;
    }

    public Vertex<T> getDest() {
        return dest;
    }

    public double getWeight() {
        return weight;
    }
}