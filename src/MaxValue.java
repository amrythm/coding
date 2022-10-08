public class MaxValue {

    public static void  main(String[] args) {

        int[] val ={1,2,3};
        int weight[] = {4,5,1};

        System.out.println(maxValue(weight, val, 4, 3));

    }

    public static int maxValue(int[] weights, int[] val, int W, int N) {

        int[] dp = new int[W+1];

        for (int i = 0; i < N ; i++) {
            for (int j = 1; j <= W  ; j++) {
                dp[i] = dp[i-1];
                //int corresponding_index = i-1;
                if(weights[i] <= j) {
                    dp[i] = Math.max(val[i] + dp[j - weights[j]],
                            dp[i]);
                }
            }
        }
        return dp[W];
    }
}
