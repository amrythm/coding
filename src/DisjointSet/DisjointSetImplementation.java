package DisjointSet;

import java.util.Arrays;

public class DisjointSetImplementation {

    public static void main(String[] args) {

        DisjointSet set = new DisjointSet(5);

        set.Union(2,3);
        set.Union(1,4);
        set.Union(4,2);

        System.out.println(set.inSameComponent(0,4));
        System.out.println(set.inSameComponent(3,1));

        for (int i: set.parent) {
            System.out.print(i + " ");
        }

    }

    public static class DisjointSet {
        public int[] rank;
       public int[] parent;

        public DisjointSet(int n) {
            rank = new int[n];
            Arrays.fill(rank, 0);
            parent = new int[n];
            for (int i = 0; i<n; i++) {
                parent[i] = i;
            }
        }

        public void Union(int a, int b) {
            a = findParent(a);
            b = findParent(b);

            if(rank[a] > rank[b]) {
                parent[b] = findParent(a);
            } else if(rank[b]> rank[a]){
                parent[a] = findParent(b);
            } else {
                rank[a]++;
                parent[b] = findParent(a);
            }
        }

        public boolean inSameComponent(int a, int b) {
            if(findParent(a) == findParent(b))
                return true;
            return false;
        }
        public int findParent(int a) {
            if(parent[a] == a)
                return a;

            return parent[a] = findParent(parent[a]);
        }
    }

}
