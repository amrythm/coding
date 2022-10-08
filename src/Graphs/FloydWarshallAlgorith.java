package Graphs;

public class FloydWarshallAlgorith {


    public static void main(String[] args) {

        int[][] matrix = {{1,1,0,1,0},
                         {1,1,0,0,1},
                         {0,0,1,1,0},
                         {0,1,1,1,0},
                         {0,0,0,0,1}} ;

        int[][] transitive_closure = transitiveClosure(matrix);

        for (int i = 0; i < transitive_closure.length; i++) {
            for (int j = 0; j < transitive_closure[0].length; j++) {
                System.out.print(transitive_closure[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static int[][] transitiveClosure(int[][] graph) {

        int n = graph.length;
        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(ans[i][j]!=0 || (ans[i][k] == 1 && ans[k][j] == 1))
                        ans[i][j] = 1;
                }
            }
        }
        return ans;
    }
 }
