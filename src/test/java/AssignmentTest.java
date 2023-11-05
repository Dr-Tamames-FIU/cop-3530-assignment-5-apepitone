import Path.*;
import Graph.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class AssignmentTest {

    @Test
    public void testIncidentEdges() throws Exception {
        List<Vertex> vertices = Path.readVertices("src/main/resources/vertex.txt");
        List<Edge> edges = Path.readEdges("src/main/resources/edge.txt");
        ExtendedGraph graph = new ExtendedGraph(vertices, edges);
        List<Edge> incidentEdges = graph.incidentEdges(graph.getVertex(1));
        String output = incidentEdges.toString();
        Assertions.assertEquals("[B A 9, B F 2, B C 12]", output);
    }

    @Test
    public void testInitializeSingleSource() throws Exception {
        List<Vertex> vertices = Path.readVertices("src/main/resources/vertex.txt");
        List<Edge> edges = Path.readEdges("src/main/resources/edge.txt");
        ExtendedGraph graph = new ExtendedGraph(vertices, edges);
        Vertex source = graph.getVertex(1);
        List<PathVertex> paths = Path.initializeSingleSource(graph, source);
        String output = "";
        for(int i = 0; i < paths.size(); i++)
            output = output + paths.get(i).info().toString();
        Assertions.assertEquals(
"(parent: null distance: 2147483647 destination: A)(parent: null distance: 0 destination: B)(parent: null distance: 2147483647 destination: C)(parent: null distance: 2147483647 destination: D)(parent: null distance: 2147483647 destination: E)(parent: null distance: 2147483647 destination: F)(parent: null distance: 2147483647 destination: G)",
        output);
    }

    @Test
    public void testDijkstra() throws Exception {
        List<Vertex> vertices = Path.readVertices("src/main/resources/vertex.txt");
        List<Edge> edges = Path.readEdges("src/main/resources/edge.txt");
        ExtendedGraph graph = new ExtendedGraph(vertices, edges);
        List<PathVertex> results = Path.dijkstra(graph, graph.getVertex(1));
        String output = "";
        for(int i = 0; i < results.size(); i++) {
            output = output + results.get(i).info();
        }
        Assertions.assertEquals(
"(parent: F distance: 5 destination: A)(parent: null distance: 0 destination: B)(parent: G distance: 8 destination: C)(parent: C distance: 9 destination: D)(parent: G distance: 9 destination: E)(parent: B distance: 2 destination: F)(parent: A distance: 6 destination: G)",
        output);
    }

}
