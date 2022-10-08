package DynamicProgramming;


//LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
// A subsequence is a sequence that appears in the same relative order, but not
// necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println(lcs(s1,s2));
    }

    public static int lcs(String s1, String s2) {

        int len_1 = s1.length();
        int len_2 = s2.length();

        int[][] lcs = new int[len_1+1][len_2+1];


        for (int i = 1; i <= len_1; i++) {
            for (int j = 1; j <= len_2; j++) {
                int index1 = i-1;
                int index2 = j-1;
                if(s1.charAt(index1) == s2.charAt(index2)) {
                    lcs[i][j] = 1 + lcs[index1][index2];
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }

        }
        return lcs[len_1][len_2];
    }
}
