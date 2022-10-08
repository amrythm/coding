package Trees;

//Given a skewed tree (Every node has at most one child) with N nodes and K colors.
// You have to assign a color from 1 to K to each node such that parent and child has different colors.
// Find the maximum number of ways of coloring the nodes.
public class ColorSkewedTree {

    public static void main(String args[]) {
        System.out.println(noOfWays(3,3));
    }
    static int noOfWays(int N, int K) {
        if(K<2 || N==0)
            return 0;

        int ans = K;
        int i = 1;
        while (i<N) {
            i++;
            ans = ans*(K-1);
        }
        return ans;
    }
}
