package BST;

import java.util.Stack;

//Given an array of numbers, return true if given array can represent
// preorder traversal of a Binary Search Tree, else return false. Expected time complexity is O(n).
public class IfArrayRepresentsPreorder {

    public static boolean canRepresentPreorder(int a[]) {
        if(a.length == 0)
            return false;

        Stack<Integer> s = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            while (!s.isEmpty() && s.peek() < a[i]) {
                root = s.pop();
            }
            if(a[i] < root)
                return false;

            s.push(a[i]);
        }
        return true;
    }
}
