package Graphs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphImplementation {

    public static void main(String[] args) {

        Graph g = new Graph(7);
//        g.addEdge(0, 1);
//        g.addEdge(0,2);
//        g.addEdge(2,3);
//        g.addEdge(6,5);
//        g.addEdge(3, 4);
//        g.addEdge(0,6);
//        g.addEdge(5,3);
//        g.addEdge(4,5);
//        g.addEdge(3, 1);
//        g.addEdge(0,3);
//        g.addEdge(6,1);
//        g.addEdge(2,5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);

        System.out.println("One mother vertex is " + g.findMotherVertex());

        g.BFS(4);
        System.out.println();
        g.BFS(6);
        System.out.println();
        g.BFS(1);
        System.out.println();
        g.BFS(0);
        System.out.println();
        g.DFS(1);
        System.out.println();
        g.DFS(6);
        System.out.println();
        g.DFS(0);

        System.out.println();
        g.topoSort();
    }

    static class Graph {
        int V;
        ArrayList<Integer>[] adj;

        Graph(int v) {
            this.V = v;
            adj = new ArrayList[V];

            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int v1, int v2) {
            adj[v1].add(v2);
        }

        void BFS(int s) {

            boolean[] visited = new boolean[V];
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            visited[s] = true;

            while (!q.isEmpty()) {
                int temp = q.poll();
                System.out.print(temp + " ");
                for (int i = 0; i <adj[temp].size() ; i++) {
                    if(!visited[adj[temp].get(i)]) {
                        q.add(adj[temp].get(i));
                        visited[adj[temp].get(i)] = true;
                    }
                }
            }

        }

        void DFS(int s) {

            boolean[] visited = new boolean[V];
            DFS(s, visited);
        }

        private void DFS(int src, boolean[] visited) {
            if(visited[src])
                return;

            visited[src] = true;
            System.out.print(src + " ");
            int i = 0;
            while (i < adj[src].size()) {
                DFS(adj[src].get(i++), visited);
            }
        }

        void topoSort() {

            Stack<Integer> s = new Stack<>();
            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++) {
                if(!visited[i]) {
                    topoSort(i, visited, s);
                }
            }

            while (!s.isEmpty())
                System.out.print(s.pop() + " ");
        }

        private void topoSort(int src, boolean[] visited, Stack<Integer> s) {
            if(visited[src])
                return;

            visited[src] = true;
            int j = 0;
            while (j< adj[src].size()) {
                topoSort(adj[src].get(j++), visited, s);
            } s.push(src);
        }

        int findMotherVertex() {

            for (int i = 0; i < V ; i++) {
                if(isMotherVertex(i))
                    return i;
            }
            return -1;
        }
        boolean isMotherVertex(int src) {

            boolean[] visited = new boolean[V];
            checkForMother(src, visited);

            for (int i = 0; i < V; i++) {
                if(!visited[i])
                    return false;
            }
            return true;
        }

        private void checkForMother(int src, boolean[] visited) {
            if(visited[src])
                return;

            visited[src] = true;
            int i = 0;
            while (i < adj[src].size()) {
                checkForMother(adj[src].get(i++), visited);
            }
        }
    }
}
