package Graphs;

public class IfPathExists {

    public static void main(String[] args) {

        int[][] grid = {{3,3,3,3,0,0,3,0},
                        {1,3,3,3,3,3,3,2},
                  {3,3,0,3,0,3,3,3},
                {3,3,3,0,0,3,0,0},
                {0,3,3,3,3,3,3,3},
                {0,0,0,3,3,0,3,3},
                {0,3,0,3,3,3,3,0},
                {3,3,3,0,3,3,3,3}};

        System.out.println(is_Possible(grid));
    }

    public static boolean is_Possible(int[][] grid)
    {

        int n = grid.length;
        int i=0,j=0; boolean flag = false;
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }

        return dfs(i,j, grid);
    }

    private static boolean dfs(int i, int j, int[][] grid) {
        if(grid[i][j] == 0)
            return false;

        if(grid[i][j] == 2)
            return true;

        grid[i][j] = -1;

        int directions[][] = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int k =0; k< directions.length; k++) {
            int i1 = i + directions[k][0];
            int j1 = j + directions[k][1];
            if(i1>=0 && i1<grid.length && j1>=0 && j1< grid.length ) {
                if(grid[i1][j1] == 3 || grid[i1][j1] == 2)
                    if(dfs(i1, j1 , grid))
                        return true;
            }

        }
        return false;


    }
}
