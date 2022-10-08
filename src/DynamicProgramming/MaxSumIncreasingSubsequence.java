package DynamicProgramming;

//Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence
// of the given array such that the integers in the subsequence are sorted in increasing order. For example, if
// input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10},
// then output should be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10
public class MaxSumIncreasingSubsequence {

    public static void main(String[] args) {

        int[] arr = {44, 42, 38, 21, 15, 22, 13, 27};

        System.out.println(maxSum(arr, 8));
    }

    public static int maxSum(int[] arr, int n) {

        int max[] = new int[n];

        max[0] = arr[0];

        for (int i = 1; i < n; i++) {
            max[i] = arr[i];
            for (int j = 0; j <i; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i] + max[j];
                    if(temp > max[i])
                        max[i] = temp;
                }
            }
        }


        int res = 0;

        for (int i = 0; i < n; i++) {
            System.out.println(max[i]);
            if(max[i]> res)
                res = max[i];
        }
        return res;
    }
}
