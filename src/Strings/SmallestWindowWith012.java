package Strings;

//Given a string S of size N consisting of the characters 0, 1 and 2, the task is to find the length of the smallest substring
// of string S that contains all the three characters 0, 1 and 2. If no such substring exists, then return -1.

import java.util.HashSet;

public class SmallestWindowWith012 {

    public static void main(String args[]) {
        String s = "12121";
        int l = s.length();

        System.out.println(findLength(s));
    }

    public static int findLength(String s) {
        if(s.length() <3)
            return -1;

        int start =0;
        int min_length = Integer.MAX_VALUE;
        HashSet<Character> set = new HashSet<>();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            if(set.contains('0') && set.contains('1') && set.contains('2')) {
                if(min_length > i-start)
                    min_length = i -start+1;
                start = i+1;
                set.remove('0');
                set.remove('1');
                set.remove('2');
                flag = true;
            }
        }
        if(flag)
        return min_length;
        else return -1;
    }
}
