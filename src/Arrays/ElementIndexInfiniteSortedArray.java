package Arrays;

public class ElementIndexInfiniteSortedArray {

    public static void main(String args[]) {
        int arr[] = new int[]{3,5,7,9,10,90, 100, 130, 140, 160, 170};
        int n = arr.length;

        if(findIndex(arr,10) == -1)
            System.out.println("Not found!!!");
        else
            System.out.println("The position of given number is "+(findIndex(arr, 10)+1));
    }

    public static int findIndex (int a[], int x) {

        int start = 0; int end = 1;
        int pos = -1;
        while (pos == -1) {

            pos = binarySearch(a, start, end, x);
            start = end + 1;
            end = end*2;
        }

        return pos;
    }

    public static int binarySearch(int a[], int l, int r, int x) {

        while (l<r) {
            int mid = (l+r)/2;
            if(x == a[mid])
                return mid;
            else if(x > a[mid])
                l = mid+1;
            else r = mid-1;
        }
        return -1;
    }
}
