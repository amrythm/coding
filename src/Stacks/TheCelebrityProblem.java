package Stacks;

import java.util.HashSet;
import java.util.Stack;

//A celebrity is a person who is known to all but does not know anyone at a party.
// If you go to a party of N people, find if there is a celebrity in the party or not.
//A square NxN matrix M[][] is used to represent people at the party such that if an element
// of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
public class TheCelebrityProblem {

    public static void main(String args[]) {
        int arr[][] = new int[][]{ {0, 1, 0},
                                    {0, 0, 0},
                                    {0, 1, 0}};

        int n = arr.length;

        System.out.println(findCelebrity(arr,n));
    }

    public static int findCelebrity(int[][] a, int n) {
        if(n==0)
            return -1;

        Stack<Integer> st = new Stack<>();
        for(int i= 0; i<n;i++)
            st.push(i);


        while (st.size() > 1) { // This function compares each pair of elemnts checking if they know each other
            int i = st.pop();
            int j = st.pop();
            if(a[i][j] == 1) { //if i knows j, then i cannot be clebrity hence j is pushed back as
                                // we cannot say anything baout j
                st.push(j);
            }else {           // if i does not know j, then j cannot be clebrity, so i is pushed back
                st.push(i);
            }
        }
        int curr_poss = st.pop();

        for (int i = 0; i < n; i++) {

            if(i!= curr_poss) {
                if (a[curr_poss][i] == 1)
                    return -1;
                if(a[i][curr_poss] == 0)
                    return -1;
            }
        }
        return curr_poss;
    }
}
