package Arrays;

public class MaxSubArraySum {

    public static void main(String args[]) {
        int arr[] = new int[]{-2,-3,-4,-2, -1,-5,-3};
        int n = arr.length;

        findSubArray(arr,n);
    }

    public static void findSubArray(int a[], int n) {

        int curr_Sum = a[0];
        int max_Sum = a[0];
        int start = 0, end =0, s=0;

        for (int i=1; i<n; i++){

            curr_Sum += a[i];
            if(curr_Sum > max_Sum) {
                max_Sum = curr_Sum;
                start = s;
                end = i;
            }
            if (curr_Sum < 0){
                curr_Sum =0;
                s = i+1;
            }
        }
        System.out.println("Max Sum of subarray is "+ max_Sum);
        System.out.println("Starting index "+ start);
        System.out.println("Ending index "+ end);
    }
}
