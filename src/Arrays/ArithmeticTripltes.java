package Arrays;

import java.util.HashSet;

public class ArithmeticTripltes {

    public static void main(String[] args) {

        int[] arr = {0,1,4,6,7,10};
        System.out.println(arithmeticTriplets(arr, 3));
    }

    public static int arithmeticTriplets(int[] nums, int diff) {

        int n = nums.length;

        int count = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for (int i = 1; i < n-1; i++) {
            if(set.contains(nums[i]-diff) && set.contains(nums[i]+diff))
                count++;
        }

        return count;
    }
}
