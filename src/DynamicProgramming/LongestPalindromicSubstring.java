package DynamicProgramming;

//Given a string, find the longest substring which is a palindrome.
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(findLongest("forgeeksskeegfor"));
    }
    public static String findLongest(String s) {

        String reversed = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            reversed = reversed + s.charAt(i);
        }

        return lcsubstring(s, reversed);
    }

    // Fisrt we create a dp a
    private static String lcsubstring(String s, String t) {

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        // in the above dp, dp[i][j] stores whether the string from the indexes i to j is a palindrome or not

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // whenevwe i and j are same the value will always be true as this means the length of current substring is 1
        // and a string of 1 length is always a palindrome

        int start = 0, end = 0; // to store the indices of maximum length substring
        int max_len = 1; // to update the max length
        for (int i = 1; i < len; i++) {
            for (int j = 0, k=i; k <len ; j++, k++) {
                // if the end characters of the given substring match, then dp[j][k] will be true if the
                // string between the given two characters is a palindrome
                if(s.charAt(j) == s.charAt(k)) {
                    if(k-j == 1) { // this is to handle the case where k and j are next to each other
                        // there is no charcter between them, hence the substring will be a palindrome
                        dp[j][k] = true;

                    } else { // if j and k are not next to each other, check if the string between them is
                        // a palindrome
                        dp[j][k] = dp[j + 1][k - 1];
                    }
                    if(dp[j][k] && max_len < k-j+1) {// whenever we find a palindrome, we check if its length is greater than
                        // previously found palindromes, and if so, we update the satrt and end values
                        start = j;
                        end = k;
                        max_len = k-j+1;
                    }
                }else dp[j][k] = false;
            }
        }
        return s.substring(start, end+1);
    }

    //Brute_Force
//
//    public static String findLongest(String s, int start, int end) {
//
//        if(isPalindrome(s, start, end)) {
//            return s.substring(start, end+1);
//        }
//
//        String a = findLongest(s, start+1, end);
//        String b = findLongest(s, start, end-1);
//
//        if(a.length() > b.length())
//            return a;
//        else return b;
//    }
//
//    private static boolean isPalindrome(String s, int start, int end) {
//        if(s.charAt(start) != s.charAt(end))
//            return false;
//        if(start>=end)
//            return true;
//
//        return isPalindrome(s, start+1, end-1);
//    }
}
