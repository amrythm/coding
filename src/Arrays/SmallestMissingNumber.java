package Arrays;

//Given a sorted array of n distinct integers where each integer is in the range from 0 to m-1 and m > n.
// Find the smallest number that is missing from the array.
public class SmallestMissingNumber {

    public static void main(String args[]) {
        int arr[] = new int[]{0,1,2,3,4,5,6,7,10};
        int n = arr.length;

        System.out.println(smallestNumber(arr, n));
    }

    public static int smallestNumber(int a[], int n) {
        int i;
        for (i = 0; i < n ; i++) {
            if (a[i] != i)
                break;
        }
        return i;
    }
}
