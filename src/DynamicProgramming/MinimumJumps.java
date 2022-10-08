package DynamicProgramming;

//Given an array of integers where each element represents the max number of steps that can be made forward from that element.
//   Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element).
//   If an element is 0, they cannot move through that element. If the end isn’t reachable, return -1.
public class MinimumJumps {

    public static void  main(String[] args) {

        int[] arr = {4, 1, 7, 5, 7, 8, 3, 8, 5, 8, 2, 4, 0 ,7 ,2, 1, 5, 7, 4, 2, 1, 8, 2, 0, 8, 0, 5};
        int n = arr.length;

        System.out.println(minJumpsGreedy(arr, n));
    }

    public static int minJumpsGreedy(int[] arr, int n) {

        if(n==0)
            return 0;
        if(arr[0] == 0)
            return -1;

        int current = 0;
        int jumps = 0;
        int next = 0;
        while (current + arr[current] < n-1) {

            int dist = 0;
            for (int i = current+1 ; i<n && i <= current+arr[current]; i++) {
                if(i + arr[i] > dist) {
                    next = i;
                    dist = i + arr[i];
                }
            }
            jumps++;
            if(next == current)
                return -1;
            current = next;
        }

        return jumps;
    }
    public static int minJumps(int[] arr, int n) {// DP Solution

        int[] jumps = new int[n];

        jumps[0] = 0;

        for (int i = 1; i < n ; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j <i ; j++) {
                //minimum number of jumps to reach a particular index + jumps from tha index
                if(jumps[j] != Integer.MAX_VALUE && i <= arr[j] + j) {
                    int temp = jumps[j] + 1;
                    if(temp < jumps[i])
                        jumps[i] = temp;
                }
            }
        }

        if(jumps[n-1] == Integer.MAX_VALUE)
            return -1;

        return jumps[n-1];
    }
}
