package SetsAndMaps;

//Given an array with positive number the task
// is that we find largest subset from array that contain elements which are Fibonacci numbers.

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestSubsetOfFibonacciNumbers {

    public static void main(String args[]) {
        int arr[] = new int[]{0, 2, 8, 5, 2, 1, 4,
                13, 23};
        int n = arr.length;

       System.out.println( findSubset(arr));
    }

    public static ArrayList<Integer> findSubset(int[] a) {

        ArrayList<Integer> ans = new ArrayList<>();


        for (int i = 0; i < a.length; i++) {
            if(isFibonacci(a[i]))
                ans.add(a[i]);
        }

        return ans;
    }

    public static boolean isFibonacci(int n) {

        int i = 0;
        int j = 1;
        int res = 0;
        while (res < n) {
            res = i+j;
            if(res == n)
                return true;
            i =j;
            j=res;
        }
        return false;
    }
}
