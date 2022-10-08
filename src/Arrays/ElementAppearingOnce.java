package Arrays;

public class ElementAppearingOnce {// to find the element which does not repeat where all other elements repeat twice
    public static void main(String args[]) {
        int arr[] = new int[]{2,3,2,3,5};
        int n = arr.length;

        System.out.println("Non-repeating number is "+ findElement(arr, n));
    }

    public static int findElement (int a[], int n) {

        int res =a[0];

        for(int i=1; i<n;i++)
            res = res^a[i];  // This represents XOR operation, XOR with duplicate numbers gives 0 and
                            //XOR with 0 gives the number itself. Hence, if we XOR all elements the result will
                            // the non-repeating number

        return res;
    }
}
