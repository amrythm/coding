package Strings;

import java.lang.reflect.Array;
import java.util.Arrays;

//Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//
//You have the following three operations permitted on a word:
//
//Insert a character
//Delete a character
//Replace a character
public class MinOperations {

    public static void main(String args[]) {
        String s1 = "execution";
        int l = s1.length();
        String s2 = "intention";
        int l2 = s2.length();

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i <= s1.length() ; i++)
            Arrays.fill(dp[i], -1);
        System.out.println(minOperationsToConvert(s1, s2, l, l2, dp));
    }

    public static int minOperationsToConvert(String word1, String word2,int m, int n, int[][] dp) {

        if(m == 0)
            return n;
        if (n ==0)
            return m;

        if(dp[m][n] != -1)
            return dp[m][n];

        //if the charcters at given positions have same value then no operation needs to be performed
        //so check for next substrings
        if(word1.charAt(m-1) == word2.charAt(n-1))
            return dp[m][n] = minOperationsToConvert(word1, word2, m-1, n-1, dp);

        // if charcters re not the same then check for each operation and find the minimum and store
        else
            return dp[m][n] = 1 + findMin(minOperationsToConvert(word1, word2, m, n-1,dp),
                                        minOperationsToConvert(word1, word2, m-1, n, dp),
                                        minOperationsToConvert(word1, word2, m-1, n-1,dp));


    }

    public static int findMin(int x, int y, int z) {
        if(x<y && x<z)
            return x;
        if(y<x && y<z)
            return y;
        else return z;
    }
}
