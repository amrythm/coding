package Greedy;

import DisjointSet.DisjointSetImplementation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// The algorithm that Kruskal's algorithm  follows is that it picks up the next minimum weighted edge greedily as long
// as including this edge does not from a cycle. If it forms a cycle we ignore this edge. To chekc for a cycle, we
// use disjoint set. If the next edge that we are picking has both its source and destination in the same set, that
// means it is forming acycle in the same componenet. Hence, we always pick the edge with source and destination in
// different component so that we are always including new vertices. When the number of edges in the MST become v-1
// i.e. one less than the number of vertices, the MST is complete
public class KruskalsMST {

    public static void main(String[] args) {

        ArrayList<Edge> graph = new ArrayList<>();
        graph.add(new Edge(0,1,10));
        graph.add(new Edge(1,3,15));
        graph.add(new Edge(3,0,5));
        graph.add(new Edge(2,3,4));
        graph.add(new Edge(2,0,6));

        for (Edge i: kruskal(graph,4)) {
            System.out.println(i.src + " "+ i.dest+ " " +i.weight);
        }
    }

    static class Edge {
        int src,  dest,  weight;
        Edge(int src, int dest, int weight) {
            this.dest = dest;
            this.src = src;
            this.weight = weight;
        }
    }
    static class Set {
        int rank, parent;
    }

    public static ArrayList<Edge> kruskal(ArrayList<Edge> graph, int v) {

        Queue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        for (Edge e:graph) {
            q.add(e);
        }

        ArrayList<Edge> MST = new ArrayList<>();
        DisjointSetImplementation.DisjointSet set = new DisjointSetImplementation.DisjointSet(v);
        for (int i = 0; i < v; i++) {
            set.rank[i] = 0;
            set.parent[i] = i;
        }

        while (!q.isEmpty()) {
            Edge e = q.poll();

            if(!set.inSameComponent(e.src,e.dest)) {
                set.Union(e.src,e.dest);
                MST.add(e);
                if(MST.size() == v-1)
                    break;
            }
        }
        return MST;
    }
}
