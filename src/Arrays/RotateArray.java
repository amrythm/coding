package Arrays;

public class RotateArray {

    public static void main(String args[]) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length;
        int arr2[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int m = arr2.length;
        rotateToLeft(arr, 2, n);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        rotateToRight(arr2, 2, n);


        System.out.println();
        for (int ele : arr2) {
            System.out.print(ele + " ");
        }
        System.out.println();
        //System.out.println(search(arr, 3));
    }

    public static void rotateToLeft(int a[], int k, int n) {

        reverse(a, 0, k-1);
        reverse(a, k, n - 1);
        reverse(a, 0, n - 1);
    }

    public static void rotateToRight(int a[], int k, int n) {
        reverse(a, 0, n-k-1);
        reverse(a,n-k,n-1);
        reverse(a, 0, n-1);
    }


    public static void reverse(int a[], int start, int end) {
        int temp;
        while (start < end) {
            temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public static int search(int a[], int value) {
        int i;
        for (i = 0; i < (a.length - 2); i++) {
            if (a[i] > a[i + 1])
                break;
        }
        if (a[i] == value)
            return i;
        int index = find(a, 0, i, value);
        if (index < 0 && i < a.length) {
            index = find(a, i + 1, a.length - 1, value);
        }
        return index;

    }

    public static int find(int a[], int start, int end, int val) {
        if (start > end)
            return -1;
        int k = (start + end) / 2;

        if (val > a[end] || val < a[start])
            return -1;

        if (val == a[end])
            return end;
        if (val == a[start])
            return start;
        if (val == a[k])
            return k;

        if (val < a[k])
            return find(a, start, k, val);
        else
            return find(a, k, end, val);

    }
}
