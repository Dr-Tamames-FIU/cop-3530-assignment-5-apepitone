package Graph;

import java.util.ArrayList;
import java.util.List;

public class ExtendedGraph extends AbstractGraph {
    public ExtendedGraph(List vertices, List edges) {
        super(vertices, edges);
    };




    
    public List<Edge> incidentEdges(Vertex v) {

        List<Edge> incidentEdges = new ArrayList<>();


            for (Edge edge : edges) {

            if (edge.vertex1.getLabel().equals(v.getLabel()) || edge.vertex2.getLabel().equals(v.getLabel())) {

                incidentEdges.add(edge);

        }

    }

    return incidentEdges;

}


    public List<Vertex> getVertices() {

        return vertices; 
        
    }


}


    

    
    

    
    

    
    

    
    




