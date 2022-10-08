package Arrays;

//Given an array of n positive integers and a number k. Find the minimum number of
// swaps required to bring all the numbers less than or equal to k together.
//
public class MinSwaps {
    public static void main(String args[]) {
        int arr[] = new int[]{7,9,2,6,13,5,4,52, 37, 12, 1};
        int n = arr.length;

        System.out.println(findSwaps(arr, 8, n));
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static int findSwaps(int a[], int k, int n) {

        int count =0;

        for(int i=0;i<n;i++) {  // count the number of elements that need to be grouped together
                                // this gives us the size of the window we need to use
            if (a[i] <= k)
                count++;
        }

        int bad = 0;
        for (int j = 0; j < count; j++) { // Count the number of unfavorable elements in the first window
            if (a[j]>k)
                bad++;
        }

        int ans = bad;
        for (int i = 1, j= count; j<n ; i++, j++) { // iterate through the elements using the window and find which
                                                            // window requires minimum swaps
                   if(a[i-1] > k)
                       ans--;          // if leaving element is unfavorbale, swaps decrease

                   if(a[j] > k)
                       ans++;         // if entering element is unfavorbale, swaps incree

                   ans = Math.min(ans, bad);
        }
        return ans;
    }
}
