package Arrays;

import java.util.Arrays;

public class PairsWithGivenDifference {

    public static void main(String args[]) {
        int arr[] = new int[]{8, 12, 16, 4, 0, 20};
        int n = arr.length;

        System.out.println("The number of pairs is " + findPairs(arr,  4));

    }

    public static int findPairs(int a[], int k) {

        Arrays.sort(a);
        int n = a.length;

        int count = 0;
        int j = 0;
        for (int i = 1; i < n; ) {
            if (a[i] - a[j] < k) {
                i++;
                continue;
            }
            if (a[i] - a[j] == k) {
                count++;

                while (i < n - 1 && a[i] == a[i + 1])
                    i++;
                i++;
            }
            j++;
        }
        return count;
    }
}
