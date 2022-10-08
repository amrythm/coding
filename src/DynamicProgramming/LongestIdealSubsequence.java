package DynamicProgramming;

public class LongestIdealSubsequence {

    public static void main(String[] args) {
        System.out.println(longestIdealString("znrkjnk", 8));
    }

    public static int longestIdealString(String s, int k) {

        int[] dp = new int[26];
        int ans = 0;
        for(int i =0; i< s.length(); i++) {
            int a = s.charAt(i)-'a';
            int m = 0;
            for(int j= Math.max(a-k,0); j<= (Math.min(a+k,25)); j++) {
                m = Math.max(m, dp[j]);
            }
            dp[a] = 1 + m;
        }

        //int ans = 0;
        for(int i=0; i< 26; i++)
            ans = Math.max(ans, dp[i]);

        return ans;
    }

}
