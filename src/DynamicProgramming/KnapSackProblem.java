package DynamicProgramming;

//Given weights and values of n items, put these items in a knapsack of capacity W to
// get the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1]
// which represent values and weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is
// smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
public class KnapSackProblem {

    public static void main(String[] args) {

        int[] values = {60,100,120};
        int[] weights = {10, 20, 30};

        System.out.println(maxValue(values,weights, 50));
     }

     static class Pair {
        int weight, value;
        Pair(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
     }
    public static int maxValue(int[] values, int[] weights, int W) {

        int[][] dp = new int[weights.length][W+1];

        for (int i = 0; i <= W; i++) {
            if(weights[0] <= i)
                dp[0][i] = values[0];
            else dp[0][i] = 0;
        }

        for (int i = 1; i < weights.length; i++) {
            for (int j = 0; j <= W; j++) {
                if(j>= weights[i]) {
                    int next_possible = Math.max(values[i] + dp[i - 1][j - weights[i]], dp[i - 1][j]);
                        dp[i][j] = next_possible;
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length-1][W];
    }
}
