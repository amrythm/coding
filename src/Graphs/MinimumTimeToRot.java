package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
//
//0: Empty cell
//1: Cells have fresh oranges
//2: Cells have rotten oranges
//Determine what is the minimum time required so that all the oranges become rotten.
// A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1]
// (up, down, left and right). If it is impossible to rot every orange then simply return -1.
public class MinimumTimeToRot {


    public static void main(String[] args) {

        int[][] grid = {{0, 0, 1, 1, 2, 0, 1},
                        {2, 0, 1, 1 ,0, 0, 0},
                        {1, 0, 0, 2, 1, 1, 2},
                        {1, 2, 0, 1, 1, 1, 1} } ;

        System.out.println(orangesRotting(grid));
    }
    static class Pair{
        int row,column, time;

        Pair(int i, int j) {
            this.row = i;
            this.column = j;
            time = 0;
        }
//        Pair(int i, int j, int time) {
//            this.row = i;
//            this.column = j;
//            this.time = time;
//        }
    }
    static int orangesRotting (int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int good = 0;
        Queue<Pair> rotten = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==1)
                    good++;
                else if(grid[i][j] == 2)
                    rotten.add(new Pair(i,j));
            }
        }

        int time = 0;
        //boolean[][] visited = new boolean[n][m];
        while (!rotten.isEmpty()) {
            Pair current = rotten.poll();
            //visited[current.row][current.column] = true;
            if(time < current.time)
            time = current.time;
                Pair temp = new Pair(current.row+1, current.column);
                    if (temp.row < n && grid[temp.row][temp.column] == 1) {

                            temp.time = current.time + 1;
                            grid[temp.row][temp.column] = 2;
                            rotten.add(temp);
                            good--;

                    }
                temp = new Pair(current.row-1, current.column);
                    if (temp.row >=0 && grid[temp.row][temp.column] == 1) {

                            temp.time = current.time + 1;
                        grid[temp.row][temp.column] = 2;
                            rotten.add(temp);
                            good--;

                    }
                temp = new Pair(current.row, current.column-1);
                    if (temp.column >=0 && grid[temp.row][temp.column] == 1) {

                            temp.time = current.time + 1;
                        grid[temp.row][temp.column] = 2;
                            rotten.add(temp);
                            good--;

                    }
                temp = new Pair(current.row, current.column+1);
                    if (temp.column <m && grid[temp.row][temp.column] == 1) {

                            temp.time = current.time + 1;
                        grid[temp.row][temp.column] = 2;
                            rotten.add(temp);
                            good--;
                }
        }
        if(good > 0){
            System.out.println("Some oranges will not rot");
            return -1;
        }
        return time;
    }


}
