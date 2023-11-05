package Graph;
/**
 * Representation of a graph vertex
 */
public class Vertex {
    private String label;   // label attached to this vertex

    /**
     * Construct a new vertex
     * @param label the label attached to this vertex
     */
    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }

    /**
     * Get a vertex label
     * @return the label attached to this vertex
     */
    public String getLabel() {
        return label;
    }
}