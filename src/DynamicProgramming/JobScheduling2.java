package DynamicProgramming;

import java.util.Arrays;

//We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
//
//You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
//
//If you choose a job that ends at time X you will be able to start another job that starts at time X.
public class JobScheduling2 {

    public static void main(String[] args) {

        int[] a = {1,2,3,4,6};
        int[] b = {3,5,10,6,9};
        int c[] = {20,20,100,70,60};

        System.out.println(jobScheduling(a,b,c));
    }

    // The problem is solved by first sorting the array in ascending order of end times.
    // then we check for each of the elements and see that if including the job gives better profit or not
    // we fill the dp in this manner
    // here we sort to improve the time complexity
    // after sorting to find the next best job we can use binary search
    // the problem can be solved without sorting in O(n^2) time
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = profit.length;
        Job[] jobs = new Job[n];

        for(int i = 0; i<n;i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> (a.end - b.end));
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for(int i = 1; i< n ;i++) {
            int temp = findNext(jobs, i);
            if(temp!= -1)
                dp[i] = Math.max(jobs[i].profit + dp[temp], dp[i-1]);
            else
                dp[i] = Math.max(dp[i-1], jobs[i].profit);

        }

        return dp[n-1];
    }

    private static int findNext(Job[] jobs, int i) {
        int low = 0; int high = i-1;

        while(low <= high) {
            int mid = (low + high)/2;
            if(jobs[mid].end <= jobs[i].start) {
                if(jobs[mid+1].end <= jobs[i].start)
                    low = mid + 1;
                else
                    return mid;
            }
            else
                high = mid-1;
        }
        return -1;
    }

    static class Job {
        int start, end, profit;
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}
