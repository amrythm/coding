package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Given a Queue consisting of first n natural numbers (in random order).
// The task is to check whether the given Queue elements can be arranged in increasing order
// in another Queue using a stack. The operation allowed are:
//1. Push and pop elements from the stack
//2. Pop (Or Dequeue) from the given Queue.
//3. Push (Or Enqueue) in the another Queue.
public class IfSortingPossible {

    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList();

        q.add(5);
        q.add(1);
        q.add(2);
        q.add(6);
        q.add(3);
        q.add(4);
        isSortingPossible(q);

    }

    public static void isSortingPossible(Queue<Integer> q) {

        Stack<Integer> s = new Stack<>();
        Queue<Integer> q2 = new LinkedList<>();
        int n = q.size();
        int expected = 1;

        while (!q.isEmpty()) {

            int front = q.peek();
            q.poll();
            if (front == expected)
                expected++;

            if (front == n) {
                q2.add(front);
                n--;
            } else {
                if (s.isEmpty()) {
                    s.push(front);
                }

                if (s.peek() < front) {
                    s.push(front);
                } else {
                    while (!s.isEmpty() && s.peek() > front) {
                        if (s.peek() == n) {
                            q2.add(s.pop());
                            n--;
                        } else {
                            System.out.println("Sorting Not Possible");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Sorting possible");

    }

}

