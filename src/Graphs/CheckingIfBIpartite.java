package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckingIfBIpartite {

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[V];

        Arrays.fill(color, -1);

        for(int i =0; i<V;i++) {
            if(color[i]== -1)
                if(!dfs(i, 0, adj, color))
                    return false;
        }

        return true;
    }

    private boolean dfs(int src, int clr_parent, ArrayList<ArrayList<Integer>>adj, int[] color ) {
        if(color[src] == clr_parent)
            return false;

        if(color[src] != -1)
            return true;

        if(clr_parent == 0)
            color[src] = 1;
        else color[src] = 0;

        for(int i =0; i<adj.get(src).size();i++) {
            if(!(dfs(adj.get(src).get(i), color[src], adj, color)))
                return false;
        }

        return true;
    }
}
