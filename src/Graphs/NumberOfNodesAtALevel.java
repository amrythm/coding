package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Given a tree represented as an undirected graph.
// Count the number of nodes at a given level l. It may be assumed that vertex 0 is the root of the tree.
public class NumberOfNodesAtALevel {

    public static void main(String[] args)
    {

        // Create a graph given
        // in the above diagram
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        int level = 2;
        System.out.print(noOfVertices(g.adj, level));
    }

    static class Graph {
        private ArrayList<ArrayList<Integer>> adj;
        int V;

        Graph(int v) {
            this.V = v;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int v1, int v2) {
            adj.get(v1).add(v2);
        }
    }


    static int noOfVertices(ArrayList<ArrayList<Integer>> adj, int l) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        q.add(0);
        int[] level = new int[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            visited[i] = false;
            level[i] = 0;
        }
        int count = 0;
        visited[0] = true;
        while (!q.isEmpty()) {

            int temp = q.poll();

            ArrayList<Integer> list = adj.get(temp);
            for (int i : list) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    level[i] = level[temp]+1;
                }
            }

            if(level[temp] == l)
                count++;
        }
        return count;
    }
}
