package Strings;

//Given a String S, reverse the string without reversing its individual words. Words are separated by dots.

public class ReverseWordsInString {

    public static void main(String args[]) {
        String s = "I.LOVE.this.program";
        int l = s.length();

        System.out.println(reverse(s));
    }

    public static String reverse(String s) {

        if(s == null)
            return s;
        if(!s.contains("."))
            return s;

        String ans ="";
        int end = s.length();
        for (int i = s.length()-1; i >=0; i--) {
            if(s.charAt(i) == '.') {
                String t = s.substring(i+1,end);
                ans = ans + t + '.';
                end = i;
            }
        }
        return ans + s.substring(0,end);
    }
}
