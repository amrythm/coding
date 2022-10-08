package Stacks;

// we have a series of n daily price quotes for a stock and we need to
// calculate the span of the stock’s price for all n days. The span Si of the stock’s price on a given day i
// is defined as the maximum number of consecutive days just before the given day,
// for which the price of the stock on the current day is less than its price on the given day.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class StockSpanProblem {

    public static void main(String args[]) {
        int arr[] = new int[]{10, 4, 5, 90, 120, 80};
        int n = arr.length;

         int[] span = findSpan(arr, n);
        for (int i:span) {
            System.out.print(i+" ");
        }
    }

    public static int[] findSpan(int[] a, int n) {

        Stack<Integer> st = new Stack<>();
        st.push(0);
        //HashMap<Integer,Integer> res = new HashMap<>();
        int[] ans = new int[n];
        //Arrays.fill(res,1);
        ans[0] =1;
        for (int i = 1; i < n; i++) {
            if(!st.isEmpty() && a[i] <= a[st.peek()]) {
                ans[i] = 1;
                st.push(i);
            } else {
                while (!st.isEmpty() && a[st.peek()] < a[i]  ) {
                     st.pop();
                }
                if(st.isEmpty())
                    ans[i] = i+1;
                else
                ans[i] = i- st.peek();
                st.push(i);
            }
        }
        return ans;
    }
}
