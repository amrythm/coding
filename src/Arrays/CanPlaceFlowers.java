package Arrays;

//Suppose you have a long flowerbed in which some of the plots are planted and some are not. However,
// flowers cannot be planted in adjacent plots - they would compete for water and both would die.
//Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
// and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

public class CanPlaceFlowers {

    public static void main(String args[]) {
        int arr[] = new int[]{1,0,0,0,1};
        int n = arr.length;

        if(plantingPossible(arr, n, 2))
        System.out.println("Planting possible bitches!!!" );
        else System.out.println("Please reduce the number of plants!!!");
    }

    public static boolean plantingPossible(int a[], int n, int k) {

        int count = 0;
        //int n = a.length;

        for (int i = 0; i < n; i++) {
            if(a[i] == 0) {

                boolean emptyLeft = (i==0) || (a[i-1] == 0);
                boolean emptyRight = (i == n-1) || (a[i+1] ==0);

                if(emptyLeft && emptyRight) {
                    a[i] = 1;
                    count++;
                }
            }
        }
        if(count<k)
            return false;
        else return true;

    }
}
