package Graph;
import java.util.List;

/**
 * Interface specifying a graph
 */
public interface Graph {

    /**
     * Return the list of vertices of this graph
     * @return the vertices as a list (which is anything iterable)
     */
    public List<Vertex> vertices();

    /**
     * Return the list of edges of this graph
     * @return the edges as a list (which is anything iterable)
     */
    public List<Edge> edges();

    /**
     * Return a collection of edges incident to (i.e. emanating from)
     * a given vertex v.
     *      i.e., the set of all edges v->w
     * @param v one of the vertices in the graph
     * @return an iterable list of edges incident to v in the graph where v acts as the source
     */
    public List incidentEdges(Vertex v);

}