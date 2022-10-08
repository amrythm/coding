package Graphs;

//Write a function, islandCount, that takes in a grid containing Ws and Ls. W represents water and L represents land.
// The function should return the number of islands on the grid. An island is a vertically or horizontally connected
// region of land.
public class NumberOfIslandsInGrid {


    public static void main (String[] args) {
        int matrix[][] = {{0,1,0,0,0},
                          {0,1,0,0,0},
                          {1,1,0,1,0},
                          {1,0,1,0,0},
                          {1,0,0,0,1},
                          {1,1,0,1,0}};

        System.out.println(numberOfIslands(matrix));
    }
    static int numberOfIslands(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 1) {
                    count(matrix, i , j);
                    ans++;
                }
            }

        }
        return ans;
    }

    private static void count(int[][] matrix, int i, int j) {
        if(matrix[i][j] == 0)
            return;

        matrix[i][j] = 0;

        int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        for (int k = 0; k < directions.length; k++) {
            int i1 = i+directions[k][0];
            int j1 = j+directions[k][1];
            if(i1>=0 && i1 < matrix.length && j1>=0 && j1 < matrix[0].length) {
                count(matrix, i1, j1);
            }
        }
    }
}
