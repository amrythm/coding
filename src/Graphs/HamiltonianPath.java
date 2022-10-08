package Graphs;


//A Hamiltonian path, is a path in an undirected or directed graph that visits each vertex exactly once.
// Given an undirected graph  the task is to check if a Hamiltonian path is present in it or not.
import java.util.ArrayList;
import java.util.Arrays;

// SOLUTION : In the solution, we start from a given vertex and add the next adjacent vertex if it is not already visited.
//If the vertex is visited, we remove it(backtrack and mark it not visited) from the path and move on to the next
 //       adjacent vertex. We do this for all the vertices, because path can start from any vertex
public class HamiltonianPath {

    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges)
    {
        int[] visited =  new int[N];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            list.get(Edges.get(i).get(0)).add(Edges.get(i).get(1));
            list.get(Edges.get(i).get(1)).add(Edges.get(i).get(0));
        }

        ArrayList<Integer> path = new ArrayList<>();
        for(int i = 0 ; i< N; i++) {
            dfs(i+1, -1, list, path, visited);
            if(path.size() == N)
                return true;
        }

        return false;
    }

    private static void dfs(int src, int parent, ArrayList<ArrayList<Integer>> list,
                            ArrayList<Integer> path, int[] visited) {

        if(visited[src-1] != 0)
            return;

        visited[src-1] = 1;
        path.add(src);

        for (int j = 0; j < list.get(src).size(); j++) {
            if(list.get(src).get(j) != parent)
                dfs(list.get(src).get(j), src, list, path, visited);
        }

        if(path.size() == visited.length)
            return;

        path.remove(path.size()-1);
        visited[src-1] = 0;

    }
}
