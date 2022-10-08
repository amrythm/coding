package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Demo {

    public static void main(String[] args) {

        int[][] Edge = {{3,5},{2,6},{2,3},{6,7},{2,8},{2,3},{4,6},{3,6},{0,4},{5,8}};

        String[] query = {"cab", "cbd", "acb", "dac", "bac", "cba", "bcd", "dba",
                "dac", "dac", "dab", "adb", "adb", "cda", "bcd", "dba"};
        //String[] query = {"dba"};

        System.out.println(solve(9, 10, 16, "bfbdbbcac", Edge, query));
    }

    public static ArrayList<String> solve(int N, int M, int Q, String col,
                                          int[][] Edge, String[] query) {
        // add your code here

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<N;i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            adj.get(Edge[i][0]).add(Edge[i][1]);
            adj.get(Edge[i][1]).add(Edge[i][0]);
        }

        ArrayList<String> ans = new ArrayList<>();
        boolean[] visited = new boolean[N];

        for(int i=0; i<Q; i++) {
            String t = query[i];
            HashSet<Character> set1 = new HashSet<>();
            for (int k = 0; k < t.length(); k++) {
                set1.add(t.charAt(k));
            }

            int src = -1;
            HashSet<Character> set = new HashSet<>();
            boolean flag = false;
            for(int k = 0; k <t.length(); k++) {
                for (int j=0; j<N; j++) {
                    if (t.charAt(k) == col.charAt(j)) {
                        src = j;
                        if (dfs(src, adj, visited, set, col, set1)) {
                            ans.add("YES");
                            flag = true;
                            break;
                        }


                        set.clear();
                        Arrays.fill(visited, false);
                    }

                }
                if(flag)
                    break;
            }

            if(ans.size() < i+1)
                ans.add("NO");
            //set1.clear();

        }

        return ans;

    }

    private static boolean dfs(int src, ArrayList<ArrayList<Integer>> adj,
                               boolean[] visited, HashSet<Character> set, String color,
                               HashSet<Character> set1 ) {
        if(visited[src] || !set1.contains(color.charAt(src)))
            return false;

        visited[src] = true;

        set.add(color.charAt(src));

        if(set.containsAll(set1))
            return true;
        if(set.size() == set1.size())
            return false;

        for(int i=0; i< adj.get(src).size();i++) {
            if(dfs(adj.get(src).get(i), adj, visited, set, color, set1))
                return true;
        }
        //set.contains(set1);

//        visited[src] = false;
//        set.remove()
        return false;

    }

//    private static boolean same(Ha, HashSet<Character> set) {
//        if(set.size() != a.length())
//            return false;
//
//        for (int i = 0; i < a.length() ; i++) {
//            if(!set.contains(a.charAt(i)))
//                return false;
//        }
//        return true;
//    }
}
