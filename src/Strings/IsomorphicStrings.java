package Strings;

//Given two strings s and t, determine if they are isomorphic.
//
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving
// the order of characters. No two characters may map to the same character, but a character may map to itself.

import java.util.HashMap;

public class IsomorphicStrings {

    public static void main(String args[]) {
        String s = "norwegian";
        int l = s.length();

        String t = "meptagosn";

        System.out.println(areIsomorphic(s, t));
    }

    public static boolean areIsomorphic(String s, String t) {

        if(s.length() != t.length() || s == null || t == null)
            return false;

        HashMap<Character, Character> map = new HashMap<>();

        for(int i =0; i< s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}
