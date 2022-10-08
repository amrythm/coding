package Arrays;

//Given a sorted array and a number x, find a pair in an array whose sum is closest to x.
public class PairWIthClosestSum {

    public static void main(String args[]) {
        int arr[] = new int[]{1, 3, 4, 7, 10, 40, 83, 89,93,94,95, 96, 99,  137, 199, 222,322,350};
        int n = arr.length;

        findPair(arr, n, 90);
    }
    public static void findPair(int a[], int n, int k){
        int l=0;
        int m = n-1;
        int val1 = l, val2 = m;

        int diff = Integer.MAX_VALUE;
        while (l<m) {

            if (Math.abs(a[l]+a[m]-k) < diff) {
                val1 = l; val2 = m ;
                diff = Math.abs(a[l] + a[m] - k);
            }

            if (a[l] + a[m] > k)
                m--;
            else l++;
        }
        System.out.println( a[val1] +  " and " + a[val2]);
    }

}
