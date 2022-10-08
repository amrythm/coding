package Graphs;


import java.util.ArrayList;

//Write a function, hasPath, that takes in an object representing the adjacency list of a directed acyclic
// graph and two nodes (src, dst). The function should return a
// boolean indicating whether or not there exists a directed path between the source and destination nodes.
public class HasPath {


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(3);
        graph.get(4).add(7);
        graph.get(6).add(2);
        graph.get(5).add(1);
        graph.get(3).add(4);

        System.out.println(hasPath(graph, 0, 3));
        System.out.println(hasPath(graph, 4, 6));
        System.out.println(hasPath(graph, 7, 2));
        System.out.println(hasPath(graph, 0, 6));
        System.out.println(hasPath(graph, 0, 7));
    }
    static boolean hasPath (ArrayList<ArrayList<Integer>> adj , int src, int dest) {

        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            visited[i] = false;
        }
            return hasPath(adj, src, dest, visited);
    }

    private static boolean hasPath( ArrayList<ArrayList<Integer>> adj , int src, int dest, boolean[] visited) {

        if(src == dest)
            return true;

        visited[src] = true;

        for (int i = 0; i < adj.get(src).size(); i++) {
            if(!visited[adj.get(src).get(i)])
                if( hasPath(adj, adj.get(src).get(i), dest, visited))
                    return true;
        }

        return false;



    }
}
