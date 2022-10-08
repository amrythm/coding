package Arrays;

import java.util.HashMap;

//Given an array of integers, and a number ‘sum’, find the number of pairs of integers
// in the array whose sum is equal to ‘sum’.
public class PairsWithGivenSum {
    public static void main(String args[]) {
        int arr[] = new int[]{10, 12, -1, 7, 6, 5, 4, 2, 1, 1, 1};
        int n = arr.length;

        System.out.println("The number of pairs with given sum is "+ findCount(arr,n, 11));

    }

    public static int findCount(int a[], int n, int sum){

        HashMap<Integer, Integer> map = new HashMap<>(); //A hashmap to store the frequency of each element
        int count = 0;
        for(int i=0; i<n;i++){
            if(map.containsKey(sum-a[i]))
                count+= map.get(sum - a[i]); // if the present value subtracted from the sum is present in the map that
                                             // means the sum exists and count should be increased by the number of times the above
                                                // occurs
            if(map.containsKey(a[i]))
                map.put(a[i],map.get(a[i])+1); // if any value already exists its frequency is updated

            else
                map.put(a[i],1);                 //if value doesn't exist already, initiate its frequency to 1
        }
        return count;

    }
}
