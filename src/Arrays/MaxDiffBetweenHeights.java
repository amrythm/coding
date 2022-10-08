package Arrays;

import java.util.Arrays;

//Given heights of n towers and a value k. We need to either increase or decrease the height
// of every tower by k (only once) where k > 0. The task is to minimize the difference between the
// heights of the longest and the shortest tower after modifications and output this difference.
public class MaxDiffBetweenHeights {

    public static void main(String args[]) {
        int arr[] = new int[]{3,9,12,16,20};
        int n = arr.length;

        System.out.println(findDiff(arr,n,7));
      /*  for (int ele:arr) {
            System.out.print(ele +" ");*/
    }
// As you were confused may time with the question, here is a more detailed expalnation
    // First of all, after sorting, as we know that we have to perform either substraction or addition by k to
    // each element, then in order to minimise the maximum difference the height of the larger towers will have to be
    // decreased and the smaller towers will have to be increased. as the array is sorted, then there would be a particular
    // index before which the heights must be increased and after which heights must be decreased. Now in order to find that
    // index we start tarversing throught the whole array with our variable i, increasing all the heights upto i and
    // increaing all the heights beyond i
    // For each traversal, we keep a track of the maximum and the minimum heights, and the value at which the difference between
    // the two is minimum is our index
    // In order to keep the track of maximum and minimum,
    // For minimum, we know that it would either be the least element (first element in a sorted array) whose height is increased
    // or the least element whose height is decreased i.e. the element whose height we are currently decreasing
    // (as we are moving from left to right and the array is sorted)
    // Similar reasoning for maximum
    public static int findDiff (int a[], int n, int k) {

        Arrays.sort(a);

       int smallest = a[0];
       int largest = a[n-1];

       int ans = largest-smallest;
       int min,max;
        for (int i = 0; i < n-1; i++) {

            min = Math.min(a[0]+k, a[i+1]-k);
            max = Math.max(a[n-1] - k, a[i]+k);
            if (min<0)
                continue;
            ans = Math.min(ans, max-min);
        }
        return ans;
    }
}
/* The algorithm works as follows. the array is sorted so that the adjacent elements are the ones
with the minimum difference. Now we store the initial maximum and minimum heights as a[0]+k and a[n-1]-k
because to minimise the difference the height of shortest tower will have to be increased and the tallest tower
will have to be decreased. We store the difference as the present answer. Now, we start iterating the array and as we
move forward, we add k to the present tower and compare it with largest. If it exceeds largest we update the value of max
(current maximum). Similarly we subtract k from the next adjacent element and compare it with smallest and  if after
substraction it is lower than smallest we update he value of min. Then we compare if max-min with ans and store th smaller value.
On complete traversal of the array ans is the maximum sum.
 */
