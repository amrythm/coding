package SetsAndMaps;

//Given an array of n positive integers. We need to find the largest increasing
// sequence of consecutive positive integers.

import java.util.HashMap;
import java.util.HashSet;

public class LongestIncreasingSubsequence {

        public static void main(String args[]) {
            int arr[] = new int[]{5, 7, 8, 7, 5};
            int n = arr.length;

            findSubsequence(arr);
        }

        public static void findSubsequence(int[] a) {

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < a.length; i++) {
                if(!map.containsKey(a[i]))
                    map.put(a[i],i);
            }

            HashSet<Integer> consecutive_indices = new HashSet<>();
            for (int i = 0; i < a.length; i++) {

                if(consecutive_indices.contains(i))
                    continue;
                int val = a[i]+1;
                HashSet<Integer> curr = new HashSet<>();
                curr.add(map.get(a[i]));
                int prev = i;
                while (map.containsKey(val)){     // till next consecutive integer is present in the array
                    // change the mapping so it is not counted for any other susequence
                    int val2 = map.get(val);
                    if(val2 > prev) {
                        prev = val2;
                        curr.add(val2);
                        val = val + 1;
                    }else break;// update to find next integer
                }
                if(consecutive_indices.size() < curr.size()) {
                    consecutive_indices = (HashSet)curr.clone();
                    curr.clear();
                }
            }
            for(int i : consecutive_indices) {
                System.out.print(a[i] +" ");
            }
        }
}
