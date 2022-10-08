package Graphs;

import java.util.LinkedList;
import java.util.Queue;


//Given a binary matrix of N x M, containing at least a value 1. The task is to find the distance of nearest
// 1 in the matrix for each cell. The distance is calculated as |i1 - i2| + |j1 - j2|, where i1, j1 are the row
// number and column number of
// the current cell and i2, j2 are the row number and column number of the nearest cell having value 1.
public class Nearest1 {


    public static void main (String[] args) {

        int grid[][] = {{1, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1},
                {1 ,0, 1, 1, 1}};

        int ans[][] = nearest(grid);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

        public static int[][] nearest(int[][] grid)
        {

            int n = grid.length;
            int m = grid[0].length;
            int[][] ans = new int[n][m];

            Queue<Pair> q = new LinkedList<>();
            for(int i = 0; i<n;i++) {
                for(int j = 0; j< m ; j++) {
                    if(grid[i][j] == 1) {
                        ans[i][j] = 0;
                        q.add(new Pair(i,j));
                    }

                    else {
                        ans[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            bfs(q, grid, ans);

            return ans;
        }

        static class Pair{
            int i, j;
            Pair(int i, int j) {
                this.i =i;
                this.j = j;
            }
        }

        private static void bfs(Queue<Pair> q, int grid[][], int[][] ans) {


            boolean[][] visited = new boolean[grid.length][grid[0].length];
            while(!q.isEmpty()) {
                Pair temp = q.poll();
                //ans[temp.i][temp.j] = temp.dist;

                int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

                for(int i=0; i<dirs.length; i++) {
                    int i1 = temp.i + dirs[i][0];
                    int j1 = temp.j + dirs[i][1];
                    if(i1>=0 && j1>=0 && i1<grid.length && j1 < grid[0].length) {
                        if(!visited[i1][j1] && ans[i1][j1] != 0) {
                            visited[i1][j1] = true;
                            ans[i1][j1] = ans[temp.i][temp.j]+1;
                            q.add(new Pair(i1,j1));

                        }
                    }

                }

            }

        }
}
