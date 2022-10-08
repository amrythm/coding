package DynamicProgramming;

//Given two strings str1 and str2 and below operations that can be performed on str1.
// Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
//
//Insert
//Remove
//Replace
//All of the above operations are of equal cost.
public class EditDistance {

    public static void main(String[] args) {

        String s1 = "intention";
        String s2 = "execution";

        System.out.println(minOperations(s1, s2));
    }

    public static int minOperations( String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];

        for (int i = 0; i <= len2 ; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= len1 ; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <=len2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1 + min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];
    }



    // BRUTE FORCE
    public static int minOperations(String s1, String s2, int i, int j) {
        if(i== 0)
            return j+1;
        if(j== 0)
            return i+1;

        if(s1.charAt(i) == s2.charAt(j))
        return minOperations(s1,  s2, i-1,j-1);


             int replacement = minOperations(s1,  s2, i-1,j-1);
             int deletion = minOperations(s1,  s2, i-1, j);
             int insertion =  minOperations(s1, s2, i, j-1);

             return 1 + min(deletion,insertion,replacement);



//        int len_1 = s1.length();
//        int len_2 = s2.length();
//
//        int[][] dp = new int[len_1+1][len_2+1];
//
//        for (int i = 1; i <= len_1 ; i++) {
//            for (int j = 1; j <= len_2; j++) {
//                int index1 = i-1;
//                int index2 = j-1;
//                if(s1.charAt(index1) != s2.charAt(index2)) {
//                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
//                }
//            }
//        }

       // return dp[len_1][len_2];
    }

    private static int min(int i1, int i2, int i3) {
        return Math.min(i1, Math.min(i2,i3));
    }


}
