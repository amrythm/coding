package Arrays;

import java.util.Arrays;

public class TripletsWithGivenSum {
    public static void main(String args[]) {
        int arr[] = new int[]{0,-1, 2, -3, 1, 4, 7, -6, 12};
        int n = arr.length;

        tripletCounts(arr, n, 16);
    }

    public static void tripletCounts(int a[], int n, int sum) {

        Arrays.sort(a);
        boolean flag = false;
        for (int i=0; i<n; i++){
            int l = i+1;
            int u = n-1;

            int k = sum - a[i];
            while (l<u) {
                if (a[l]+a[u] == k) {
                    flag = true;
                    System.out.println("The triplets are "+ a[i] + " "+a[l]+" "+a[u]);
                    l++;
                    u--;
                }
                if(a[l]+a[u] > k)
                    u--;
                else l++;
            }
        }
        if (!flag)
            System.out.println("No Triplets bro!!!!");
    }
}
