package Arrays;

import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {


        int m = matrix.length;

        for(int i=0; i<m;i++) {
            for(int j=i; j<m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


        for(int i=0; i<m;i++) {
            for(int j =0; j<m/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-j-1];
                matrix[i][m-j-1] = temp;
            }
        }
    }
}
