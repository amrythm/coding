package Graphs;

import java.util.ArrayList;

//Given an array of lowercase strings A[] of size N, determine if the strings can be chained together to form a circle.
//A string X can be chained together with another string Y if the last character of X is same as first
//character of Y. If every string of the array can be chained, it will form a circle.
//
//For example, for the array arr[] = {"for", "geek", "rig", "kaf"} the answer will be Yes as
// the given strings can be chained as "for", "rig", "geek" and "kaf"
public class CircleOfStrings {

    public static void main(String[] args) {
        String A[] = {"lgyhvltamb", "rhjzvgegwl", "bxbzilrhmq", "qrakqpleqr"};

        System.out.println(isCircle(4, A));
    }

    static int isCircle(int N, String A[])
    {
        int[] in_degree = new int[26];
        ArrayList<ArrayList<Integer>> graph = createGraph(A, in_degree);


        if(isEulerianCyclePossible(graph, in_degree))
            return 1;

        return 0;

    }

    private static boolean isEulerianCyclePossible(ArrayList<ArrayList<Integer>> graph, int[] inDegree) {

        int[] visited = new int[26];

        int j=0;
        for (; j < graph.size(); j++) {
            if(graph.get(j).size()!=0)
                break;
        }
        dfs(j, graph, visited);

        int count = 0;
        int count2 = 0;
        for(int i = 0; i< visited.length;i++) {
            count+= visited[i];
            if(graph.get(i).size() != 0)
                count2++;
        }
        if(count != count2)
            return false;


        for (int i = 0; i < graph.size(); i++) {
            if(graph.get(i).size() != inDegree[i])
                return false;
        }

        return true;

    }

    private static void dfs(int src, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        if(visited[src] == 1)
            return;

        visited[src] = 1;

        for(int i = 0 ; i< graph.get(src).size();i++) {
            dfs(graph.get(src).get(i), graph, visited);
        }
    }

    private static ArrayList<ArrayList<Integer>> createGraph(String[] A, int[] in_degree) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < A.length; i++) {
            String s = A[i];
            //if(s.charAt(0) != s.charAt(s.length()-1)) {
            graph.get(s.charAt(0) - 'a').add(s.charAt(s.length()-1) - 'a');
            in_degree[s.charAt(s.length()-1) - 'a']++;
            // }
        }

        return graph;
    }
}
