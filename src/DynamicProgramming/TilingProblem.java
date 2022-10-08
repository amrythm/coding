package DynamicProgramming;

import java.util.Arrays;

public class TilingProblem {


    public static void main(String[] args) {
        System.out.println(numberOfWays(24151));
    }
    static Long numberOfWays(int N) {

        if(N==0)
            return 0L;

        if(N==1)
            return 1L;


        long[] count = new long[N];
        Arrays.fill(count, 0L);
        count[0] = 1;
        count[1] = 2;
        //count[2] = 2;

        for(int i= 2; i<N;i++) {
            count[i] = count[i-1] + count[i-2];
        }
        return count[N-1];
    }
}
