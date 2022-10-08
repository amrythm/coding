package DynamicProgramming;

import java.util.Arrays;

//Given a value V, if we want to make a change for V cents, and we have an infinite supply of each of
// C = { C1, C2, .., Cm} valued coins,
// what is the minimum number of coins to make the change? If it’s not possible to make a change, print -1.
public class MinCoinsUsed {

    public static void main(String[] args) {

        int[] C = {9, 2, 11, 5, 14, 17, 8, 18};

        System.out.println(coinsUsed(39, C));
    }

    public static int coinsUsed(int V, int[] C) {

        int N = C.length;
        int[][] dp = new int[N][V+1];

//        for (int i = 0; i <N ; i++) {
//            for (int j = 0; j <=V ; j++) {
//                dp[i][j] = Integer.MAX_VALUE;
//            }
//
//        }

        for (int i = 0; i <= V ; i++) {
            if(i%C[0] == 0)
                dp[0][i] = i/C[0];
            else dp[0][i] = 0;
        }

        for (int i = 0; i < N; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= V ; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k <= i ; k++) {
                    if(C[k] <= j) {
                        int temp = dp[i][j - C[k]];
                        if (temp != Integer.MAX_VALUE && dp[i][j] > 1 + temp)
                            dp[i][j] = 1 + temp;
                    }
                }
            }
        }

        return dp[N-1][V];
    }
}
