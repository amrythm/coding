package Greedy;

import java.util.*;

public class DjikstrasImplementation {

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int n = adj.size();
        int[] min_dist = new int[n];
        Arrays.fill(min_dist, Integer.MAX_VALUE);
        min_dist[S] = 0;

        Queue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.min_dist));
        q.add(new Pair(S,min_dist[S]));

        while (!q.isEmpty()) {
                  Pair next = q.poll();
                  int src = next.index;
            for (int i = 0; i < adj.get(next.index).size(); i++) {
                ArrayList<Integer> next_vertex = adj.get(next.index).get(i);
                if(next.min_dist + next_vertex.get(1) < min_dist[next_vertex.get(0)]) {
                    min_dist[next_vertex.get(0)] = next.min_dist + next_vertex.get(1);
                    q.add(new Pair(next_vertex.get(0), min_dist[next_vertex.get(0)]));
                }
            }
        }


        return min_dist;
    }

    static class Pair{
        int index, min_dist;
        Pair(int index, int min_dist) {
            this.index = index;
            this.min_dist = min_dist;
        }

    }
}
