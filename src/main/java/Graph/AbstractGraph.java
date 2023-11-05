package Graph;
import java.util.List;

/**
 * Abstract implementation of a graph.
 * Must be extended to create a particular kind of graph.
 */
public abstract class AbstractGraph implements Graph {

    // Graph representation - an iterable list of vertices and edges
    protected List<Vertex> vertices;
    protected List<Edge> edges;

    /**
     * Construct a new abstract graph
     * @param vertices the initial list of verticies in the graph
     * @param edges the initial list of edges in the graph
     */
    AbstractGraph(List vertices, List edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    /**
     * Return the vertices in this graph
     * @return the list of vertices in this graph
     */
    public List vertices() {
        return vertices;
    }

    /**
     * Return the vertex in this graph using indices
     * @return the vertex using indices
     */
    public Vertex getVertex(int index) {
        return this.vertices.get(index);
    }

    /**
     * Return the edges in this graph
     * @return the list of edges in this graph
     */
    public List edges() {
        return edges;
    }

}