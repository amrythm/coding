package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;

public class WordBreak {

    public static void main(String[] args) {
        String[] arr = {"i", "like", "sam", "samsung", "sung","well"};

        System.out.println(ifBreakPossible( "ilikesamsung", arr));
    }

    private static boolean dictionaryContains(String[] arr, String s) {

        int n = arr.length;
        for (int i = 0; i <n ; i++) {
            String temp = arr[i];
            if(s.length() == temp.length()) {
                int x = 0;
                while (x< temp.length()) {
                    if(s.charAt(x) != temp.charAt(x))
                        break;
                    x++;
                }
                if(x== temp.length())
                    return true;
            }
        }
        return false;
    }
    public static boolean ifBreakPossible(String s, String[] arr) {

        int len = s.length();
        int n = arr.length;
        int dp[] = new int[len+1];
        // The above dp contains the number of words that can be formed till the given index

        for (int i = 1; i <= len ; i++) {
            for (int j = 0; j <i ; j++) {
                String cur = s.substring(j,i);
                if(dictionaryContains( arr, s.substring(j,i))) {
                    if(dp[j] == 0)
                        dp[i]++;
                    else
                    dp[i] = 1 + dp[j];
                }
            }
        }
        for (int i: dp) {
            System.out.print(i +" ");
        }
        System.out.println();
        return dp[len] >0;

    }

    //BRUTE FORCE
//    public static boolean ifBreakPossible(String s, String[] arr, int i) {
//        if(i >= s.length())
//            return true;
//
//
//        for (int k = 0; k < arr.length; k++) {
//            if(s.charAt(i) == arr[k].charAt(0)) {
//                int x = 1;
//                while (x< arr[k].length()) {
//                    if(s.charAt(i+x) != arr[k].charAt(x))
//                        break;
//                    x++;
//                }
//                if(x== arr[k].length())
//                    if(ifBreakPossible(s, arr, i))
//                        return true;
//            }
//        }
//        return false;
//    }
}
