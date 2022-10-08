package DynamicProgramming;

//Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
// Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if the length
// of the rod is 8 and the values of different pieces are given as the following,
// then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
public class RodCuttingProblem {


    public static void main(String[] args) {
        int[] prices = {1,5,8,9,10,17,17,20};

        System.out.println(maxVal(8, prices));
    }
    public static int maxVal(int N, int[] prices) {

        int[] gain = new int[N+1];

        gain[0] = 0;
        gain[1] = prices[0];


        for (int i = 2; i <= N; i++) {
            gain[i] = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                int res = prices[j-1] + gain[i - j];
                if (res > gain[i])
                    gain[i] = res;
            }
        }

        return gain[N];
    }

}
