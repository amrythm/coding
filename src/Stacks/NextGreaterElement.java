package Stacks;

import java.util.HashMap;
import java.util.Stack;

//Given an array, print the Next Greater Element (NGE) for every element.
// The Next greater Element for an element x is the first greater element on the right
// side of x in the array. Elements for which no greater element exist, consider the next greater element as -1.
public class NextGreaterElement {

    public static void main(String args[]) {
        int arr[] = new int[]{10, 4, 5, 90, 120, 80};
        int n = arr.length;

        int nge[] = findNextGreater(arr, n);
        for (int i: nge) {
            System.out.print( i+" ");
        }
    }

    public static int[] findNextGreater(int a[], int n) {
        if(n==0)
            return null;

        int[] ans = new int[n];
        ans[n-1] = -1;
        Stack<Integer> s = new Stack<>();
        s.push(a[n-1]);
        for (int i = n-2; i >=0; i--) {
            if(a[i] < s.peek()) {
                ans[i] = s.peek();
                s.push(a[i]);
            } else {
                while (!s.isEmpty() && a[i] >= s.peek()) {
                    s.pop();
                }
                if(s.isEmpty())
                    ans[i] = -1;
                else
                ans[i] = s.peek();
                s.push(a[i]);
            }
        }
        return ans;
    }
}
