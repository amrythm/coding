package DynamicProgramming;

//
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        System.out.println(findMaxLength("GEEKSFORGEEKS"));
    }
    public static int findMaxLength( String s) {
        
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0,k = i; k<len; k++, j++) {
                if(i==0)
                    dp[j][k] = 1;
                else if(s.charAt(j) == s.charAt(k))
                    dp[j][k] = 2 + dp[j+1][k-1];
                else dp[j][k] = Math.max(dp[j+1][k], dp[j][k-1]);
            }
        }
        return dp[0][len-1];

//       if(start == end )
//           return 1;
//       if (start > end)
//           return 0;
//
//       if(s.charAt(start) == s.charAt(end))
//           return 2+ findMaxLength(s, start+1, end-1);
//
//       return Math.max(findMaxLength(s, start+1, end), findMaxLength(s, start, end-1));
    }
}
