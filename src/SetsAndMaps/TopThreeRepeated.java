package SetsAndMaps;

//Given an array of size N with repeated numbers, You Have to Find the top three repeated numbers.
//Note : If Number comes same number of times then our output is one who comes first in array

import java.util.HashMap;

public class TopThreeRepeated {

    public static void main(String args[]) {
        int arr[] = new int[]{3, 4, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3};
        int n = arr.length;

        findRepeated(arr);
    }

    public static void findRepeated(int[] a) {

        if(a.length <3)
            return;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }


        int j = 0;
        int max = 0;
        while (j < 3) {
            int d=0;
            for (int i = 0; i < a.length; i++) {
                if (map.getOrDefault(a[i],0) > d) {
                    d = map.get(a[i]);
                    max = a[i];
                }
            }
            j++;
            map.remove(max);
            System.out.println(max);
        }
    }
}
