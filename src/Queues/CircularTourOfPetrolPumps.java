package Queues;

import java.util.Deque;
import java.util.LinkedList;

//Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.
//
//The amount of petrol that every petrol pump has.
//Distance from that petrol pump to the next petrol pump.
//Calculate the first point from where a truck will be able to complete the circle
// (The truck will stop at each petrol pump and it has infinite capacity).
// Expected time complexity is O(n). Assume for 1-litre petrol, the truck can go 1 unit of distance.
public class CircularTourOfPetrolPumps {

    static class Pair{
        int a,b;
        Pair(int x, int y){
            a=x;
            b=y;
        }
    }
    public static void main(String args[]) {

        Pair p1 = new Pair(4,6);

         Pair arr[] = new Pair[]{new Pair(4,6), new Pair(6,5), new Pair(7,3), new Pair(4,5)};
        int n = arr.length;

        System.out.println(circularTour(arr, n));
    }

    public static int circularTour(Pair[] a, int n) {

        int petrol_left[] = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int temp = a[i].a - a[i].b;
                sum += temp;

                petrol_left[i] = sum;

        }
        sum = 0;
        if(petrol_left[n-1]<0)
            return -1;

        int curr = -1;
        int i = 0;
        while (a[i].a - a[i].b <0) {
            sum+=petrol_left[i];
            i++;
        }
        curr = i;
        for (; i < n; i++) {
            if((petrol_left[i] - sum)  <0) {
                sum = petrol_left[i] - sum;
                curr = i + 1;
            }
        }

        return curr;
    }
}
