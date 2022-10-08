package DynamicProgramming;

public class SubsetSum {

    public static void main(String[] args) {
        int arr[] = {57, 68, 27, 100, 69, 49, 100, 51, 71, 63, 77, 20, 63, 4, 11, 31, 21, 23,
                94, 5, 56, 54, 15, 88, 61, 89, 5, 22, 83, 55, 90, 39, 74, 16, 38, 42, 17, 37, 93,
                39, 52, 69, 59, 14, 24, 21, 96, 96, 43, 89, 100, 51, 95, 15, 38, 7, 55, 42, 28, 37,
                49, 69, 75, 74, 36, 12, 16, 52, 1, 60, 43, 52, 80, 53, 65, 55, 73, 12, 50, 68, 100,
                50, 18, 94, 16, 7, 100, 70, 1, 79, 58, 49, 47, 32, 74, 35, 95, 89, 38, 47};

        System.out.println(ifSumExists(5142, arr));
    }

    public static boolean ifSumExists(int sum, int[] arr) {

        int N = arr.length;

        boolean[][] dp = new boolean[N][sum+1];

        for (int i = 0; i <= sum; i++) {
            if(arr[0] == i)
                dp[0][i] = true;
            else dp[0][i] = false;
        }

        for (int i = 0; i <N; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <N ; i++) {
            for (int j = 1; j <= sum ; j++) {
                if(j >= arr[i])
                dp[i][j] = dp[i-1][j- arr[i]] || dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[N-1][sum];
    }


    //BRUTE_FORCE
//    public static boolean ifSumExists(int sum, int[] arr) {
//
//        return ifSumExists(sum, arr, 0);
//    }
//
//    public static boolean ifSumExists(int sum, int[] arr, int index) {
//        if(sum == 0)
//            return true;
//        if(sum < 0)
//            return false;
//        if(index == arr.length)
//            return false;
//
//        int curr_val = arr[index];
//        boolean picked = ifSumExists(sum - curr_val, arr, index+1);
//        boolean not_picked = ifSumExists(sum, arr, index+1);
//
//        return picked || not_picked;
//    }
}
