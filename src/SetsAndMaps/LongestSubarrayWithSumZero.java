package SetsAndMaps;

import java.util.HashMap;

//Given an array of integers, find the length of the longest sub-array with a sum that equals 0.
public class LongestSubarrayWithSumZero {

    public static void main(String args[]) {
        int arr[] = new int[]{15, -2, 2, -8,31, -22, 7, 9, -11, 17, -8, 1, 7, 10, 23};
        int n = arr.length;

        System.out.println(findSubArrayLength(arr));
    }

    public static int findSubArrayLength(int[] a) {

        int curr_sum = 0;
        int max_len = 1;

        int start =0;
        int end =0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int k = 0; k < a.length; k++) {
            curr_sum += a[k];
            if(map.containsKey(curr_sum)) {
                if(max_len < (k-map.get(curr_sum))) {
                    max_len = k - map.get(curr_sum) ;
                    start = map.get(curr_sum)+1;
                    end =k;
                }
                continue;
            }
            map.put(curr_sum, k);
        }
        for (int l = start; l <= end ; l++) {
            System.out.print(a[l] + " ");
        }
        System.out.println();
        return max_len;
    }
}
