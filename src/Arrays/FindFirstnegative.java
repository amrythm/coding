package Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class FindFirstnegative {

    public static void main(String[] args) {

        int[] arr = {-8,2,3,-6,0};


        for (int i: findNegative(arr, 2, 5)) {
            System.out.print(i + " ");
        }
    }

    public static int[] findNegative(int[] a, int K, int N) {
        Queue<Integer> q = new LinkedList<>();

        int i;
        for (i = 0; i < K; i++) {
            if (a[i] < 0)
                q.add(i);
        }

        int[] res = new int[N - K + 1];

        int ind = 0;
        for (; i < N; i++) {

            if (!q.isEmpty()) {
                res[ind++] = a[q.peek()];
            } else res[ind++] = 0;

            if (!q.isEmpty() && q.peek() < i - K + 1)
                q.poll();

            if (a[i] < 0)
                q.add(i);

        }

        if(!q.isEmpty())
            res[ind] = a[q.peek()];

        return res;
    }

}
