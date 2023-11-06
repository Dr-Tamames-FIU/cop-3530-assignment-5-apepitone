package Graph;

import java.util.List;

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
   

    public int getIndex(ExtendedGraph extendedGraph) {

        List<Vertex> vertices = extendedGraph.getVertices(); 
            for (int i = 0; i < vertices.size(); i++) {

            if (vertices.get(i).getLabel().equals(this.getLabel())) {

                return i;

            }

        }

        return -1; // Return -1 if the vertex is not found
        
    }

}