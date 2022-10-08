package Graphs;

import java.util.ArrayList;
import java.util.HashMap;

//Write a function, undirectedPath, that takes in an array of edges for an undirected graph and two nodes (nodeA, nodeB).
// The function should return a boolean indicating whether or not there exists a path between nodeA and nodeB.
public class UndirectedPath {

    public static void main(String[] args) {

        int[][] edges = {{0,1},{2,0}, {4,2}, {2,3}, {5,6}};

        System.out.println(ifPathExists(edges, 4,1));
        System.out.println(ifPathExists(edges, 1,4));
        System.out.println(ifPathExists(edges, 1,3));
        System.out.println(ifPathExists(edges, 2,6));
        System.out.println(ifPathExists(edges, 6,1));

    }

    static boolean ifPathExists(int edges[][], int src, int dest) {
        HashMap graph = constructGraph(edges);

        boolean[] visited = new boolean[graph.size()];

        return hasPath(graph, src, dest, visited);

    }

    static boolean hasPath(HashMap<Integer, ArrayList<Integer>> graph, int src, int dest, boolean[] visited) {
        if(src == dest)
            return true;

        if(visited[src])
            return false;

        visited[src] = true;

        for(int i=0; i< graph.get(src).size(); i++) {
            if(hasPath(graph, graph.get(src).get(i), dest, visited))
                return true;
        }

        return false;
    }

    private static HashMap<Integer, ArrayList<Integer>> constructGraph(int[][] edges) {

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            if(!graph.containsKey(edges[i][0])) {
                graph.put(edges[i][0], new ArrayList<>());
            } if(!graph.containsKey(edges[i][1])) {
                graph.put(edges[i][1], new ArrayList<>());
            }
            graph.get(edges[i][1]).add(edges[i][0]);
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        return graph;
    }
}
