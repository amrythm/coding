package Strings;

//Given a string containing just the characters '(' and ')', find the length
// of the longest valid (well-formed) parentheses substring.

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String args[]) {
        String s = "()(()))))";
        int l = s.length();

        System.out.println(findSubString(s));
    }

    public static int findSubString(String s) {

        Stack<Integer> ch = new Stack<>();
        ch.push(-1);
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                ch.push(i);
            }
            else{
                if(!ch.isEmpty())
                ch.pop();
                if(!ch.isEmpty()) {
                    if (maxLength < (i - ch.peek()))
                        maxLength = i - ch.peek();
                }
                else ch.push(i);
            }
        }
        return maxLength;
    }
}
