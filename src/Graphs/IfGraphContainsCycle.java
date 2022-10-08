package Graphs;

import java.util.ArrayList;

public class IfGraphContainsCycle {

    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(2);
        graph.get(4).add(2);
        graph.get(0).add(3);
        graph.get(4).add(1);
        graph.get(1).add(2);

        System.out.println(containsCycle(graph));
        graph.get(2).add(3);
        System.out.println(containsCycle(graph));
        graph.get(3).add(1);
        System.out.println(containsCycle(graph));
    }

    public static boolean containsCycle(ArrayList<ArrayList<Integer>> graph) {

        boolean visited[] = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if(dfs(graph,i, visited))
                return true;
        }

        return false;
    }
    private static boolean dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited) {
        if(visited[src])
            return true;

        visited[src] = true;

        for (int i = 0; i < graph.get(src).size(); i++) {
            if(dfs(graph, graph.get(src).get(i), visited))
                return true;
        }

        visited[src] = false;
        return false;

    }
}
