package Arrays;

public class MaxTripletSum {

    public static void main(String args[]) {
        int arr[] = new int[]{9,8,20,3,4,-1,0};
        int n = arr.length;

        System.out.println("Maximum Triplet sum is "+ findTriplet(arr, n));
    }

    public static int findTriplet (int a[], int n) {


        int max_A = Integer.MIN_VALUE;
        int max_B = Integer.MIN_VALUE;
        int max_C = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            if(a[i]>=max_A) {
                max_C = max_B;
                max_B = max_A;
                max_A = a[i];
            }
            else if (a[i]>= max_B) {
                max_C = max_B;
                max_B = a[i];
            }
            else if (a[i]>= max_C)
                max_C = a[i];
        }
        return max_A+max_B+max_C;
    }
}
