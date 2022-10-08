package SetsAndMaps;

//Given an array of integers, find the length of the longest sub-sequence such that elements
// in the subsequence are consecutive integers, the consecutive numbers can be in any order.

//THE CODE WRITTEN BELOW ALO PRINTS THE ELEMENTS 8)

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveIntegersubsequence {

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
            while (map.containsKey(val)){     // till next consecutive integer is present in the array
                                                    // change the mapping so it is not counted for any other susequenc
                int val2 = map.get(val);
                    curr.add(val2);
                    val = val + 1;
                // update to find next integer
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
