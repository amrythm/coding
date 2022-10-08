package Miscellaneous;


import java.util.Arrays;

//An Array of integers is given, both +ve and -ve.
// You need to find the two elements such that their sum is closest to zero.
public class SumClosestToZero {

    public static int closestToZero (int arr[], int n)
    {
            if(n < 2)
                return -1;

            Arrays.sort(arr);

            int left = 0;
            int right = n-1;
            int min_sum = arr[left]+arr[right];
            while(left < right) {
                int sum = arr[left] + arr[right];
                if(sum == 0)
                    return 0;
                if(sum < 0) {
                    if(Math.abs(min_sum) >Math.abs(sum))
                        min_sum = sum;
                    left++;
                }else {
                    if(Math.abs(min_sum) >= sum)
                        min_sum = sum;
                    right--;
                }
            }
            return min_sum;

        }
}
