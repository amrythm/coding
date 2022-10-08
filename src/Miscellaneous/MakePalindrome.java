package Miscellaneous;

//Given an array of positive integers. We need to make the given array a ‘Palindrome’.
// The only allowed operation is”merging” (of two adjacent elements). Merging two adjacent elements
// means replacing them with their sum.The task is to find the minimum number of merge operations
// required to make the given array a ‘Palindrome’.
//
//To make any array a palindrome, we can simply apply merge operation n-1 times where n is the size
// of the array (because a single-element array is always palindromic, similar to single-character string).
// In that case, the size of array will be reduced to 1. But in this problem, we are asked to do it in the
// minimum number of operations.
public class MakePalindrome {

    public static void main(String[] args) {
        int arr[] = {37,53,12,16,40,23,27};

        System.out.println(findMinOperations(arr,0, arr.length-1));
    }

    static int findMinOperations(int[] arr, int begin, int end) {
        if((end - begin) <= 0)
            return 0;

        if(end - begin == 1) {
            if(arr[begin] == arr[end])
                return 0;
            else return 1;
        }

        if(arr[begin] == arr[end]) {
            return findMinOperations(arr,begin+1,end-1);
        }
        if(arr[begin] > arr[end]) {
            arr[end-1] = arr[end-1]+arr[end];
            return 1 + findMinOperations(arr, begin, end-1);
        }
        else {
            arr[begin+1] = arr[begin]+arr[begin+1];
            return 1+ findMinOperations(arr, begin+1, end);
        }
    }
}
