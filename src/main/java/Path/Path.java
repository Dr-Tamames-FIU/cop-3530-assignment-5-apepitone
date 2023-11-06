package Path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import Graph.Vertex;
import Graph.Edge;
import Graph.ExtendedGraph;

public class Path {
    public static void main(String args[]) throws Exception
    {
        List<Vertex> vertices = readVertices("src/main/resources/vertex.txt");
        List<Edge> edges = readEdges("src/main/resources/edge.txt");

        ExtendedGraph graph = new ExtendedGraph(vertices, edges);
//        Testing
//        List<Edge> incidentEdges = graph.incidentEdges(graph.getVertex(1));
//        System.out.println(incidentEdges.toString());
//        expected output: "[B A 9, B F 2, B C 12]"

//        Vertex source = graph.getVertex(1);
//        System.out.println("Source: " + source);
//        List<PathVertex> paths = initializeSingleSource(graph, source);
//        String pathsInStringForm = "";
//        for(int i = 0; i < paths.size(); i++)
//            pathsInStringForm = pathsInStringForm + paths.get(i).info().toString();
//        System.out.println(pathsInStringForm)
//        expected output: "(parent: null distance: 2147483647 destination: A)(parent: null distance: 0 destination: B)(parent: null distance: 2147483647 destination: C)(parent: null distance: 2147483647 destination: D)(parent: null distance: 2147483647 destination: E)(parent: null distance: 2147483647 destination: F)(parent: null distance: 2147483647 destination: G)"

//        List<PathVertex> results = dijkstra(graph, graph.getVertex(1));
//        String resultsInStringForm = "";
//        for(int i = 0; i < results.size(); i++) {
//            resultsInStringForm = resultsInStringForm + results.get(i).info();
//        }
//        System.out.print(resultsInStringForm);
//        expected output: "(parent: F distance: 5 destination: A)(parent: null distance: 0 destination: B)(parent: G distance: 8 destination: C)(parent: C distance: 9 destination: D)(parent: G distance: 9 destination: E)(parent: B distance: 2 destination: F)(parent: A distance: 6 destination: G)"

    }

    
   public static List<PathVertex> dijkstra(ExtendedGraph g, Vertex v){

        List<PathVertex> paths = initializeSingleSource(g, v);

        PriorityQueue<PathVertex> pq = new PriorityQueue<>(Comparator.comparingInt(paths::indexOf));

        PathVertex sourcePathVertex = paths.get(v.getIndex(g));

        sourcePathVertex.distance = 0; 

        pq.add(sourcePathVertex);

            while (!pq.isEmpty()) {

                PathVertex pv = pq.poll();

            if (pv.visited) continue;

                pv.visited = true;

                 List<Edge> edges = g.incidentEdges(pv);

            for (Edge edge : edges) {

                Vertex incidentVertex = (edge.vertex1 == pv) ? edge.vertex2 : edge.vertex1;

                int incidentVertexIndex = incidentVertex.getIndex(g);

                PathVertex incidentPathVertex = paths.get(incidentVertexIndex);

                int newDistance = pv.distance + edge.weight;

            if (newDistance < incidentPathVertex.distance) {

                incidentPathVertex.distance = newDistance;

                incidentPathVertex.parent = pv;

                pq.remove(incidentPathVertex);

                pq.add(incidentPathVertex);

            }
        }
    }

    return paths;
}
    // ** TO DO **

    public static List<PathVertex> initializeSingleSource(ExtendedGraph g, Vertex s) {

        List<Vertex> vertices = g.getVertices();

        List<PathVertex> pathVertices = new ArrayList<>();

            for (Vertex v : vertices) {

            PathVertex pathVertex = new PathVertex(v.getLabel());

            pathVertex.parent = null;

            pathVertex.distance = (v == s) ? 0 : Integer.MAX_VALUE;

            pathVertices.add(pathVertex);

    }

    return pathVertices;
    
}     

    // *** ignore below ***

    public static List<Vertex> readVertices(String filePath) throws Exception {
        String vertexFile = readFile(filePath);
        List<String> verticesList = new ArrayList<>(Arrays.asList(vertexFile.split("\n")));
        List<Vertex> vertices = new ArrayList<>();
        for(int i = 0; i < verticesList.size(); i++) {
            vertices.add(new Vertex(verticesList.get(i).trim()));
        }
        return vertices;
    }

    public static List<Edge> readEdges(String filePath) throws Exception {
        String edgeFile = readFile(filePath);
        List<String> edgesList = new ArrayList<>(Arrays.asList(edgeFile.split("\n")));
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < edgesList.size(); i = i + 3) {
            Vertex v1 = new Vertex(edgesList.get(i).trim());
            Vertex v2 = new Vertex(edgesList.get(i+1).trim());
            Integer weight = Integer.parseInt(edgesList.get(i+2).trim());
            Edge e = new Edge(v1, v2, weight);
            edges.add(e);
        }
        return edges;
    }

    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}