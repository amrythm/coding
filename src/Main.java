public class Main {
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,4,5,6};
        int n = arr.length;
        int d = 2;
    }

    public static int[] rotateArray(int arr[], int n, int d){
        int temp;

        for (int i=0; i<n; i++){
            temp = arr[i];
            if ( (i+d) >= n) {
                arr[i] = arr[i+d-n];
                arr[i+d-n] = temp;
            }
            else {
                arr[i] = arr[i + d];
                arr[i+d] = temp;
            }
        }


        return null;
    }
}
