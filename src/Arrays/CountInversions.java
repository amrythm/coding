package Arrays;

//Given an array of N integers, count the inversion of the array (using merge-sort).
//
//What is an inversion of an array? Definition: for all i & j < size of array, if i < j
// then you have to find pair (A[i],A[j]) such that A[j] < A[i].
public class CountInversions {

    public static void main(String[] args) {
        int[] arr = {5,7,8,3,6,1,1,3};

        System.out.println(mergeSort(arr,0, 7));;
    }

    public static int mergeSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }

        int count = 0;
        int mid = (lo + hi) / 2;
        count += mergeSort(arr, lo, mid);
        count += mergeSort(arr, mid + 1, hi);

        count += merge(arr, lo, mid, hi);

        return count;
    }

    public static int merge(int[] arr, int lo, int mid, int hi) {

        int i = lo;
        int j = mid+1;
        int k = 0;

        int[] res = new int[hi-lo+1];

        int count = 0;
        while (i <=mid && j <=hi) {

            if(arr[i] <= arr[j]) {
                res[k++] = arr[i++];
            } else {
                count += (mid - i +1);
                res[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            res[k++] = arr[i++];
        }
        while (j <= hi) {
            res[k++] = arr[j++];
        }

        for (int l = lo; l <=hi ; l++) {
            arr[l] = res[l-lo];
        }
        return count;
    }
}

//         return res;
//     }

