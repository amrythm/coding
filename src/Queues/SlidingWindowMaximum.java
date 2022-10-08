package Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
public class SlidingWindowMaximum {

    public static void main(String args[]) {
        int arr[] = new int[]{40, 19, 7, 14, 20, 5};
        int n = arr.length;

        findMax(arr, n, 3);
    }

    public static void findMax(int[] a, int n, int k) {


        // Create a Double Ended Queue, Qi
        // that will store indexes of array elements
        // The queue will store indexes of
        // useful elements in every window and it will
        // maintain decreasing order of values
        // from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()]
        // are sorted in decreasing order
        Deque<Integer> dq = new LinkedList<Integer>();

        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < k; ++i) {

            while (!dq.isEmpty() && a[i]>= a[dq.peekLast()])
                dq.removeLast();

            dq.addLast(i);
        }
        for (; i <n; ++i) {

            System.out.print(a[dq.peekFirst()] + " ");

            while (!dq.isEmpty() && (dq.peekFirst() <= (i-k)))
                dq.removeFirst();

            while (!dq.isEmpty() && a[i] >= a[dq.peekLast()])
                dq.removeLast();

            dq.addLast(i);
        }
        System.out.println(a[dq.peek()]);
    }

}

