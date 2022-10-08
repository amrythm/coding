package DynamicProgramming;


//There are N stations on route of a train. The train goes from station 0 to N-1. The ticket cost for all pair
// of stations (i, j) is given where j is greater than i. Find the minimum cost to reach the destination.
public class MinCostPath {

    public static int minPath(int[][] Path) {

        int N = Path.length;
        int[] dp = new int[N];

        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j <i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + Path[j][i]);
            }
        }

        return dp[N-1];
    }
}
