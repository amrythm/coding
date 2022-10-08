package Greedy;

import java.util.Arrays;
import java.util.HashSet;

public class JobScheduling {

    public static void main(String[] args) {
        Job[] arr = {new Job(1,4,20), new Job(2,1,10),
                        new Job(3,1,40), new Job(4,1,30)};

        for (int i: scheduling(arr,4)) {
            System.out.print(i+" ");
        }
    }

    static int[] scheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (a,b) -> (b.profit - a.profit));

        int sequence[] = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = -1;
        }

        int jobs_scheduled = 0;
        int profit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline-1; j >=0 ; j--) {
                if(sequence[j] == -1) {
                    sequence[j] = arr[i].id;
                    profit+= arr[i].profit;
                    jobs_scheduled++;
                    break;
                }
            }
        }

        int[] res = new int[2];
        res[0] = jobs_scheduled;
        res[1] = profit;

        return res;
    }

        static class Job {
            int id, profit, deadline;
            Job(int x, int y, int z){
                this.id = x;
                this.deadline = y;
                this.profit = z;
            }
        }

}
