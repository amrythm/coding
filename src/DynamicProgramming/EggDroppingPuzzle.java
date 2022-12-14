package DynamicProgramming;

//The following is a description of the instance of this famous puzzle involving n=2 eggs
// and a building with k=36 floors.
//Suppose that we wish to know which stories in a 36-storey building are safe to drop eggs from,
// and which will cause the eggs to break on landing. We make a few assumptions:
//…..An egg that survives a fall can be used again.
//…..A broken egg must be discarded.
//…..The effect of a fall is the same for all eggs.
//…..If an egg breaks when dropped, then it would break if dropped from a higher floor.
//…..If an egg survives a fall then it would survive a shorter fall.
//…..It is not ruled out that the first-floor windows break eggs, nor is it ruled out thatthe 36th-floor do not
// cause an egg to break.
//If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be
// carried out in only one way. Drop the egg from the first-floor window; if it survives, drop it from the
// second-floor window. Continue upward until it breaks. In the worst case, this method may require 36 droppings.
// Suppose 2 eggs are available. What is the least number of egg-droppings that is guaranteed to work in all cases?
//The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be
// dropped so that the total number of trials are minimized.
public class EggDroppingPuzzle {

    public static void main(String[] args) {
        System.out.println(minDrops(2,100));
    }

    public static int minDrops(int eggs, int floors) {

        int[][] dp = new int[eggs+1][floors+1];

        for(int i = 0; i<=eggs;i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }
        for(int i = 0; i<=floors;i++) {
            dp[1][i] = i;
            dp[0][i] = 0;
        }

        int res;
        for (int e = 2; e <= eggs; e++) {
            for (int i = 2; i <= floors ; i++) {
                dp[e][i] = Integer.MAX_VALUE;
                for (int j = 1; j <=i; j++) {
                    res = 1 + Math.max(dp[e-1][j-1], dp[e][i-j]);
                    if(res < dp[e][i])
                        dp[e][i] = res;
                }
            }
        }
        return dp[eggs][floors];
    }
}
