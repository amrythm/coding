package SetsAndMaps;

//Given an array of n positive integers that represent lengths. Find out the maximum possible area whose four
// sides are picked from given array.
// Note that a rectangle can only be formed if there are two pairs of equal values in given array.

import java.util.Arrays;
import java.util.HashMap;

public class MaxAreaRectangle {

    public static void main(String args[]) {
        int arr[] = new int[]{4, 2, 1, 4, 6, 6, 2, 5 };
        int n = arr.length;

        System.out.println(findDimensions(arr, n));
    }

    public static int findDimensions(int[] a, int n) {

//        Arrays.sort(a);
//        int l =0;
//        int b = 0;
//        for (int i = n-1; i > 0 ; i--) {
//            if(a[i] == a[i-1]) {
//                if(l != 0) {
//                    b = a[i];
//                    break;
//                } else {
//                    l = a[i];
//                    i--;
//                }
//            }
//        }
//        System.out.println("Dimesnions are " + l + " " + b);
//        return l*b;

        //SECOND SOLUTION

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            freq.put(a[i], freq.getOrDefault(a[i], 0) + 1);
        }

        int l = 0;
        int b = 0;

        for (int k : freq.keySet()) {
            if (freq.get(k) >= 2) {
                if (l < k) {
                    b = l;
                    l = k;
                }
            }
        }
        System.out.println("Dimesnions are " + l + " " + b);
        return l * b;
    }
}
