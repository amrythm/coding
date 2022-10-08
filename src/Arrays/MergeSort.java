package Arrays;

public class MergeSort {

    public static void main(String args[]) {
        int arr[] = new int[]{12,11,13,5, 6,7,-3, 52, 12, 63};
        int n = arr.length;

        mergeSort(arr, 0, n-1);
        for (int ele: arr) {
            System.out.print(ele +" ");
        }
    }

    public static void mergeSort(int a[], int l, int r) {

        if(l<r) {
            int mid = (l+r)/2;
            mergeSort(a, l, mid);
            mergeSort(a, mid+1, r);
            merge(a,l,mid,r);
        }
    }

    public static void merge(int a[], int x, int y, int z) {

        int size1 = y-x+1;
        int size2 = z-y;

        int a1[] = new int[size1];
        int a2[] = new int[size2];

        for(int i=0;i<size1; i++) {
            a1[i] = a[x+i];
        }
        for(int i=0;i<size2; i++) {
            a2[i] = a[y+i+1];
        }
        int l=0, m=0;
        for (int i = x; i < x + size1 + size2; i++) {
            if (l < size1 && m < size2) {
                if (a1[l] > a2[m]) {
                    a[i] = a2[m];
                    m++;
                } else {
                    a[i] = a1[l];
                    l++;
                }
            }
            else if (m <size2) {
                a[i] = a2[m];
                m++;
            } else if (l<size1) {
                a[i] = a1[l];
                l++;
            }
        }
    }
}
