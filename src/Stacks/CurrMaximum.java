package Stacks;

//Given a Stack, keep track of the maximum value in it. The maximum value may be the top element
// of the stack, but once a new element is pushed or
// an element is popped from the stack, the maximum element will be now from the rest of the elements.

import java.util.Stack;

public class CurrMaximum {

    public static void main(String args[]) {
        int arr[] = new int[]{40, 19, 7, 14, 20, 5};
        int n = arr.length;

        trackMax(arr, n);
    }

    public static void trackMax(int[] a, int n) {

        Stack<Integer> s = new Stack<>();
        int[] res = new int[n];

        s.push(a[0]) ;
        res[0] = 0;
        for (int i = 1; i < n; i++) {

            System.out.println(s.peek());
            if(s.peek() < a[i]) {
                s.pop();
                s.push(a[i]);
            }
        }
        System.out.println(s.peek());
    }
}
