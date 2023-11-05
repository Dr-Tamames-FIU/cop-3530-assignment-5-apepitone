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

    // ** TO DO **
    public static List<PathVertex> dijkstra(ExtendedGraph g, Vertex v){
        // Instantiating and assigning the paths to be tracked after each iteration
        // ...

        // Create a priority queue that is exactly the same thing as paths but
        // used for extracting minimum. This gets one element smaller after each iteration (see below)
        // ...

        // while...
            // always starts each iteration with the smallest PathVertex, pv
            // ...

            // We set the visited attribute of the smallest PathVertex to true
            // so that we can skip it when updating the priority queue.
            // ...

            // retrieve all edges incident to pv
            // ...

            // look into (not visit) all vertices incident to pv
            // for...
                // ...

                // since the vertex (incidentVertex of type Vertex) returned from incident vertex
                // does not hold information about its current distance to the source,
                // we look for its exact counterpart in paths (incidentPathVertex of type PathVertex):
                // for...
                    // ...
                    // ...

                        // see IF the edge needs to be relaxed
                        // ...

                            // if so, update the path vertices in pq
                            // ...

        return new ArrayList<PathVertex>();
    }

    private static PriorityQueue<PathVertex> updatePriorityQueueDistances(List<PathVertex> paths) {
        PriorityQueue<PathVertex> pq = new PriorityQueue<>(new SortByDistance());
        for(int i = 0; i < paths.size(); i++) {
            PathVertex currentPV = paths.get(i);

            // If the currentPV is visited, skip
            // This is how the priority queue gets smaller
            if(currentPV.visited) {
                continue;
            }

            pq.add(currentPV);
        }
        return pq;
    }

    // ** TO DO **
    public static List<PathVertex> initializeSingleSource(ExtendedGraph g, Vertex s) {
        // This sets every PathVertex's parent to null and its distance to the source infinity
        // except for the source (s) where its distance is 0
        // get the vertices (which is of type Vertex) from g and create a List of type PathVertex
        return new ArrayList<PathVertex>();
    }

    public static boolean relaxEdge(PathVertex v, PathVertex w, int weight) {
        if(!v.distance.equals(Integer.MAX_VALUE) && v.distance + weight < w.distance) {
            w.distance = v.distance + weight;
            w.parent = v;
            return true;
        }
        return false;
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
