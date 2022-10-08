package Graphs;


import java.util.LinkedList;
import java.util.Queue;

//Given a MxN matrix where each element can either be 0 or 1. We need to find the shortest path between
// a given source cell to a destination cell. The path can only be created out of a cell if its value is 1.
public class ShortestPathInMaze {

    public static void main(String[] args) {

        int mat[][] = {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                        { 0, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};

        System.out.println(findPath(mat, 0, 0, 4, 6));
    }

    static class Position {
        int x,y;
        int dist;

        Position (int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = 0;
         }
    }

    public static int findPath(int[][] maze, int i1, int j1, int i2, int j2) {

        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Position> q = new LinkedList<>();

        Position start = new Position(i1,j1);
        visited[i1][j1] = true;
        q.add(start);

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!q.isEmpty()) {
            Position temp = q.poll();

            if(temp.x == i2 && temp.y == j2)
                return temp.dist;

            for (int i = 0; i < 4; i++) {
                Position next = new Position(temp.x + directions[i][0],temp.y + directions[i][1]);
                if(next.x>=0 && next.x < m && next.y>=0 && next.y<n) {
                    if (maze[next.x][next.y] == 1) {
                        next.dist = temp.dist + 1;
                        q.add(next);
                        maze[next.x][next.y] = 0;
                    }
                }
            }
        }
        return -1;
    }

}
