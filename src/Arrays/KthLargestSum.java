package Arrays;

import java.util.PriorityQueue;

//Given an array of integers. Write a program to find the K-th
// largest sum of contiguous subarray within the array of numbers which has negative and positive numbers.
public class KthLargestSum {

    public static void main(String args[]) {
        int arr[] = new int[]{10, -10, 20, -40};
        int n = arr.length;

        findSubArray(arr,n, 6);
    }

    public static void findSubArray(int a[], int n, int k) {

        int sum[] = new int[n+1];
        sum[0] = 0;

        for(int i=1; i<=n; i++) {
            sum[i] = sum[i-1] + a[i-1];
        }

        PriorityQueue<Integer> Q = new PriorityQueue<Integer>();

        for (int i=1; i<=n;i++) {
            for(int j=i; j<=n; j++) {

                int x = sum[j] - sum[i-1];


                if(Q.size()< k)
                    Q.add(x);

                else {
                    if(Q.peek() < x) {
                        Q.poll();
                        Q.add(x);
                    }
                }
            }
        }

        System.out.println(k+"th largest sum is "+ Q.poll());
    }
}
