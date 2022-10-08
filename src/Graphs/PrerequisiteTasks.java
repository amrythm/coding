package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class PrerequisiteTasks {

    public static void main(String[] args) {
        int[][] pre = {{1,0},{2,1},{3,2}};
        System.out.println(isPossible(4, pre));

    }

    public static boolean isPossible(int N, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i =0; i<N; i++)
            list.add(new ArrayList<>());

        for(int i=0; i < prerequisites.length;i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        HashSet<Integer> finished = new HashSet<>();
        for(int i = 0; i< N ; i++) {
                if(dfs(i, list, finished))
                    return true;
        }

        return false;
    }
    private static boolean dfs(int src,ArrayList<ArrayList<Integer>> list,
                               HashSet<Integer> visited) {



        if(visited.contains(src))
            return false;

        if(visited.size() == list.size())
            return true;

        visited.add(src);


        for(int i =0; i<list.get(src).size();i++) {
            if(dfs(list.get(src).get(i), list, visited))
                return true;
        }

        visited.remove(visited.size()-1);
        return false;
    }
}
