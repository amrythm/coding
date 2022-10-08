package Strings;

//Given a string s, return the longest palindromic substring in s

public class LongestPalindromicSubString {


    public static void main(String args[]) {
        String s = "racecardear";
        int l = s.length();

        System.out.println(findSubString(s,l));
    }
    public static String findSubString(String s, int l) {

        int start = 0;
        int end = 0;
        int max_length = 0;
        for (int i = 0; i <l; i++) {
            int len1 = moveFromCentre(s, i, i);
            int len2 = moveFromCentre(s,i,i+1);
            int len = Math.max(len1,len2);

            if(len > max_length) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
                max_length = len;
            }
        }

        String s1 = s.substring(start, end+1);
        return s1;
    }

    private static int moveFromCentre(String s, int left, int right) {

        while(left>=0 && right< s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return (right - left - 1); //1 is substracted from length because the indices have reached the point
        // where palindrome ends on eiter side
    }
}
