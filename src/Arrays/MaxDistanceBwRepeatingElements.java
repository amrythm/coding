package Arrays;

//Given an array with repeated elements, the task is to find the maximum
// distance between two occurrences of an element.
import java.util.HashMap;

public class MaxDistanceBwRepeatingElements {

    public static void main(String args[]) {
        int arr[] = new int[]{3,2,1,2,1,4,5,8,6,7,4,2};
        int n = arr.length;

        System.out.println("The max distance is " + findDifference(arr, n));

    }

    public static int findDifference(int a[], int n) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int max_dist = 0;
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(a[i]))
            map.put(a[i],i);

            else if (max_dist < i-map.get(a[i])){
                max_dist = i-map.get(a[i]);
            }
        }
        return max_dist;
    }
}
