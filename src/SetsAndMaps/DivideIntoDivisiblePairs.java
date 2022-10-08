package SetsAndMaps;

import java.util.HashMap;

//Given an array of integers and a number k, write a function that
// returns true if the given array can be divided into pairs such that the sum of every pair is divisible by k.
public class DivideIntoDivisiblePairs {

    public static void main(String args[]) {
        int arr[] = new int[]{92, 75, 65, 48, 45, 35};
        int n = arr.length;

        System.out.println(canBeDivided(arr, 10));
    }
        public static boolean canBeDivided(int[] a, int k) {

            if(a.length%2 !=0)
                return false;

            HashMap<Integer,Integer> freq_remainders = new HashMap<>();

            for (int i = 0; i < a.length; i++) {
                freq_remainders.put(a[i]%k, freq_remainders.getOrDefault(a[i]%k,0)+1);
            }

            if(freq_remainders.getOrDefault(0,0)%2 !=0)
                return false;
            if(k%2==0 && freq_remainders.getOrDefault(k/2,0)%2 !=0)
                return false;
            for (int i = 0; i <= k/2; i++) {
                if(freq_remainders.getOrDefault(i,0) != freq_remainders.getOrDefault(k-i,0))
                    return false;
            }
            return true;
        }
}
