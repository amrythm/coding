package Strings;

import java.util.Stack;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
public class ValidParentheses {

    public static void main(String args[]) {
        String s = "[[{}()]]{{";
        int l = s.length();

        System.out.println(isValid(s,l));
    }

    public static boolean isValid(String s, int l) {

        Stack<Character> stack = new Stack<>();
        if(s.charAt(0) == ')' && s.charAt(0) != ']')
            return false;


        for(int i=0; i< l; i++) {
            if(s.charAt(i) == '(')
                stack.add(s.charAt(i));
            else if(s.charAt(i) == '[')
                stack.add(s.charAt(i));
            else if(s.charAt(i) == ']') {
                if(stack.pop() != '[')
                    return false;
            }
            else if(s.charAt(i) == ')') {
                if(stack.pop() != '(')
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else return false;
    }
}
