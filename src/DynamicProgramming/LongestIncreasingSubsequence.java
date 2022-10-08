package DynamicProgramming;


import java.util.Arrays;

//The Longest Increasing Subsequence (LIS) problem is to find the length of the
// longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order.
// For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
public class LongestIncreasingSubsequence {


    public static void main(String[] args) {

        int[] arr = {10,9,2,5,3,7,101,18};

        System.out.println(lis(arr));
    }
    public static int lis(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        // this dp contains trhe size of the maximum increasing subsequence
        // ending with the value at thois index

        dp[0] = 1;

        for(int i =1 ; i< n; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 +dp[j]);
                }
            }
        }

        int res = 0;
        for(int i:dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
