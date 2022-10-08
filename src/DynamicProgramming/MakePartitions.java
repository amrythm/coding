package DynamicProgramming;

import java.util.HashMap;

//Given an array arr[]. The task is to divide arr[] into the maximum number of partitions, such that,
// those partitions if sorted individually make the whole sorted array sorted.
public class MakePartitions {

    public static void main(String[] args) {
        int arr[] = {2,0,1,3};
        System.out.println(partitions(arr));
    }

    // The question basically states that in each partition, all the elements must be lesser than or equal to
    //all the elements of the next partition which gives us i.e. max of partition i must be lessser than
    // minimum of partition j
    public static int partitions(int[] arr) {

        int n = arr.length;
        int partitions = 0;
        int[] left_max = new int[n];
        int[] right_min = new int[n];

        left_max[0] = arr[0];
        right_min[n-1] = arr[n-1];
        for (int i = 1; i <n ; i++) {
            left_max[i] = Math.max(arr[i], left_max[i-1]);
        }

        for (int i = n-2; i >=0 ; i--) {
            left_max[i] = Math.min(arr[i], left_max[i+1]);
        }

        for (int i = 0; i < n-1; i++) {
            if(left_max[i] < right_min[i+1])
                partitions++;
        }
        return partitions+1;

    }
}
