package Graph;
/**
 * Representation of a directed graph edge
 */
public class Edge {

    // instance variables
    public Vertex vertex1, vertex2;
    public Integer weight;

    /**
     * Construct a new edge
     * @param v1 source vertex
     * @param v2 sink vertex
     * Ex. v -> w; v = source, w = sink
     * @param wt the distance or weight of this edge
     */
    public Edge(Vertex v1, Vertex v2, Integer wt) {
        vertex1 = v1;
        vertex2 = v2;
        weight = wt;
    }

    // used for printing
    public String toString() {
        return vertex1.toString() + " " + vertex2.toString() + " " + weight;
    }

}