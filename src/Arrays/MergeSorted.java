package Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeSorted {

    public static void main(String args[]) {
        int arr[] = new int[]{1, 5, 9, 10, 15, 20};
        int m = arr.length;

        int arr2[] = new int[]{2,3,8,13};
        int n = arr2.length;

        merge(arr, m, arr2, n);

        for (int ele:arr) {
            System.out.print(ele+ " ");
        }
        System.out.println();
        for (int ele:arr2) {
            System.out.print(ele+ " ");
        }
    }

    public static void merge(int a[], int m, int b[], int n) {

     /*   PriorityQueue<Integer> q = new PriorityQueue<>();

        int max = Math.max(m,n);
        int count_a=0, count_b=0;
        for(int i=0;i<m+n;i++) {
            if(count_a<m)
            q.add(a[count_a++]);
            if(count_b<n)
            q.add(b[count_b++]);

            if(i<m)
            a[i] = q.poll();
            else b[i-m] = q.poll();
        }*/ // The above process uses extra space, without extra space solution is below

        for (int i = 0; i < m; i++) {

            if(a[i] > b[0]) {
                int temp = a[i];
                a[i] = b[0];
                b[0] = temp;

                Arrays.sort(b);
            }
        }
    }
}
