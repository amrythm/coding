package SetsAndMaps;

//Given an array of strings (all lowercase letters), the task is to group them in such a way that all strings
// in a group are shifted versions of each other. Two string S and T are called shifted if,
//
//S.length = T.length
//and
//S[i] = T[i] + K for
//1 <= i <= S.length  for a constant integer K
//For example strings, {acd, dfg, wyz, yab, mop} are shifted versions of each other.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {

    public static void main(String args[]) {
        String string_arr[] = new String[]{"acd", "dfg", "wyz", "yab", "mop",
                "bdfh", "a", "x", "moqs"};
       // int n = arr.length;

        group(string_arr);
    }

    public static void group(String[] s) {

        HashMap <String, List<String>> map = new HashMap<>();

        for (int i = 0; i < s.length; i++) {

            String t = char_diff(s[i]);
            if(map.containsKey(t)) {
                map.get(t).add(s[i]);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s[i]);
                map.put(t,l);
            }
        }
        for(String t : map.keySet()) {
            System.out.println(map.get(t));
        }

    }
    public static String char_diff(String s) {

        String res ="";
        for (int i = 0; i < s.length()-1; i++) {
            int diff = s.charAt(i+1)-s.charAt(i);
            if(diff<0)
                diff += 26;

            res = res + diff +'a';
        }
        return res;
    }
}
