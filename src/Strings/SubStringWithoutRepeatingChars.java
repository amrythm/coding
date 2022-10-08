package Strings;

import java.util.HashMap;
import java.util.HashSet;

//Given a string s, find the length of the longest substring without repeating characters.
public class SubStringWithoutRepeatingChars {

    public static void main(String args[]) {
        String s = "racecardear";
        int l = s.length();

        System.out.println(findSubString(s,l));
    }

    public static String findSubString(String s, int l) {

        if(l == 0)
            return null;
        if(l==1)
            return s;

        HashSet<Character> set = new HashSet<>();
        String res;
        int start =0;
        int end = 0;
        int i=0;
        int j=0;
        int maxLength = -1;

        while(j<s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            else {
                if (j - i > maxLength) {
                    maxLength = j - i;
                    start = i;
                    end = j - 1;
                }
                set.remove(s.charAt(i));
                i++;
            }
        }

        res = s.substring(start, end+1);
        return res;
    }
}
