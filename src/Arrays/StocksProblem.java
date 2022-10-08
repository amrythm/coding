package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class StocksProblem {

    public static void main(String args[]) {
        int arr[] = new int[]{2, 30, 15, 10, 8, 25, 80};
        int n = arr.length;

        System.out.println("The maximum profit is "+ maxProfit(arr,n));
    }

    public static int maxProfit (int a[], int n) {

        int[][][] dp = new int[n][3][2];

        for (int i = 0; i < 3; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -a[0];
        }
        for (int i = 0; i <n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 3; j++) {
                dp[i][j][0] = Math.max(a[i] + dp[i-1][j][1], dp[i-1][j][0]);
                dp[i][j][1] = Math.max(-a[i] + dp[i-1][j-1][0], dp[i-1][j][1]);
            }
        }

        return dp[n-1][2][0];
    }
}
