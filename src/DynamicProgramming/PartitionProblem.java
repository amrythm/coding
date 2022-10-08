package DynamicProgramming;

import java.util.HashSet;

public class PartitionProblem {

    public static void main (String[] args) {
        int[] a = {3,1,5};

        System.out.println(isPartitionPossible(a));
    }

    public static boolean isPartitionPossible(int[] arr) {

        int N = arr.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum+= arr[i];
        }

        if(sum%2 != 0)
            return false;

        HashSet<Integer> visited = new HashSet<>();

        return isPartitionPossible(arr,N, visited, sum/2);
    }

    private static boolean isPartitionPossible(int[] arr, int N, HashSet<Integer> visited, int sum) {
        if(sum == 0)
            return true;
        if(sum < 0)
            return false;
        if(visited.size() == N)
            return false;

        for (int i = 0; i < N ; i++) {
            if(!visited.contains(i)) {
                visited.add(i);
                if (isPartitionPossible(arr, N, visited, sum - arr[i]))
                    return true;
                visited.remove(i);
            }
        }
        return false;
    }
}
