package DynamicProgramming;

//Given a value N, if we want to make change for N cents, and we have infinite supply of each of
// S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
public class CoinChange {

    public static void main(String[] args) {

        int[] s = {1,2,3};
        System.out.println(change(4, s));
    }

    public static int change(int N, int[] s) {

        int[][] change = new int[s.length][N+1];

        for (int i = 0; i <= N; i++) {
            if(i%s[0] == 0)
            change[0][i] = 1;
            else
                change[0][i] = 0;
        }

        for (int i = 1; i < s.length; i++) {
            for (int j = 0; j <= N; j++) {
                if(j < s[i])
                change[i][j] = change[i-1][j];
                else
                    change[i][j] = change[i-1][j] + change[i][j-s[i]];
            }
        }

        return change[s.length-1][N];
    }
}
