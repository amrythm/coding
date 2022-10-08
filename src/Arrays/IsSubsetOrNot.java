package Arrays;

import java.util.Arrays;

//Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not.
// Both the arrays are not in sorted order. It may be assumed that elements in both array are distinct.
public class IsSubsetOrNot {

    public static void main(String args[]) {
        int arr[] = new int[]{1,2,3,4,5,6};
        int n = arr.length;
        int arr2[] = new int[]{1,2,4,7};
        int m = arr2.length;

        if(isSubSet(arr,n,arr2,m))
        System.out.println("Is a subset!!");
        else System.out.println("Not a subset!!");
    }

    public static boolean isSubSet (int a[], int n, int b[], int m) {

        Arrays.sort(a);
        Arrays.sort(b);

        int count =0;
        for (int i = 0; i < n; i++) {
            if (a[i]!=b[count])
                continue;
            if(count == m-1)
                return true;
            count++;
        }
        return false;

    }
}
