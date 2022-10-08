package Arrays;

import java.util.PriorityQueue;

public class SortAlmostSorted {

    public static void main(String args[]) {
        int arr[] = new int[]{2, 6, 3, 12, 56, 8};
        int n = arr.length;

        sort(arr, n, 3);
    }


    public static void sort(int a[], int n, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>();

        int higher = Math.min(n,k);
        for (int i=0; i<k; i++) {
            q.add(a[i]);
        }

        for(int i = k; i<n; i++) {
            a[i-k] = q.poll();
            q.add(a[i]);
        }
        int i = n-k;
        while(!q.isEmpty()) {
            a[i++] = q.poll();
        }

        for (int ele:a) {
            System.out.print(ele +" ");
        }
    }
}
