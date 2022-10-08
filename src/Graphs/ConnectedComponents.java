package Graphs;


import java.util.ArrayList;

//Write a function, connectedComponentsCount, that takes in the adjacency list of an undirected graph.
// The function should return the number of connected components within the graph.
public class ConnectedComponents {


    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(8);
        graph.get(0).add(1);
        graph.get(0).add(5);
        graph.get(1).add(0);
        graph.get(5).add(8);
        graph.get(8).add(0);
        graph.get(8).add(5);
        graph.get(2).add(4);
        graph.get(2).add(3);
        graph.get(3).add(2);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(4).add(2);
        graph.get(3).add(8);
        graph.get(8).add(3);

        System.out.println(countConnectedComponents(graph));
    }
    static int countConnectedComponents (ArrayList<ArrayList<Integer>> graph){

        boolean visited[] = new boolean[graph.size()];
        int max_count = 0;
        ArrayList<Integer> components = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            if(!visited[i]) {
                 mark(i, graph, visited,components);
                if(max_count < components.size())
                max_count = components.size();
                components.clear();
            }
        }
        return max_count;
    }

    private static void mark(int src, ArrayList<ArrayList<Integer>> graph, boolean[] visited, ArrayList<Integer> components) {
        if(visited[src])
            return;

        visited[src] = true;
        components.add(src);
        for (int i = 0; i < graph.get(src).size(); i++) {
             mark(graph.get(src).get(i), graph, visited, components);
        }
    }


}
