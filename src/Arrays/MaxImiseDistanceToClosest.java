package Arrays;

public class MaxImiseDistanceToClosest{ //given an array with 0's and 1's, find the position where we can place
    //another 1 such that its distance is mamximum from its adjacent 1's

    public static void main(String args[]) {
        int arr[] = new int[]{0,0,1};
        int n = arr.length;

        System.out.println("The maximum distance which sitter can have from adjacent person is " + findDistance(arr));

    }

    public static int findDistance(int seats[]) {

        int prev = -1, next = 0;
        int n = seats.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                // find filled seat at or to the left of i
                prev = i;
            } else {
                // find filled seat at or to the right of i
                while (next < n && seats[next] == 0 || next < i) {
                    next++;
                }

                int left = prev == -1 ? n : i - prev;
                int right = next == n ? n : next - i;
                ans = Math.max(ans, Math.min(left, right));
            }
        }
        return ans;
    }
}
