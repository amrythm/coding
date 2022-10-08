package DynamicProgramming;

public class SmallestSubarrayWithSum {

    public static void main(String[] args)
    {
        int arr1[] = {1, 3, 4, 7, 10, 10, 8, 10};
        int x = 10;
        int n1 = arr1.length;
        int res1 = minLen(arr1, n1, x);
        if (res1 == -1)
            System.out.println("Not Possible");
        else
            System.out.println(res1);


        int arr2[] = {1, 10, 5, 2, 7};
        int n2 = arr2.length;
        x = 9;
        int res2 = minLen(arr2, n2, x);
        if (res2 == -1)
            System.out.println("Not Possible");
        else
            System.out.println(res2);

        int arr3[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        int n3 = arr3.length;
        x = 280;
        int res3 = minLen(arr3, n3, x);
        if (res3 == -1)
            System.out.println("Not Possible");
        else
            System.out.println(res3);
    }

    public static int minLen(int[] arr, int n, int sum) {

        int min_len = n+1;
        for (int i = 0; i < n; i++) {

                int temp_sum = 0;
                int temp_len = 0;
                for (int j = i; j >=0; j--) {
                    temp_sum += arr[j];
                    if(sum < temp_sum) {
                        min_len = Math.min(min_len,1+ temp_len);
                        break;
                    } else {
                        temp_len++;
                    }
                }
            }
        return min_len;
    }
}
