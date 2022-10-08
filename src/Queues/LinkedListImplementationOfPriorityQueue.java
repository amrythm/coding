package Queues;

import java.util.LinkedList;

public class LinkedListImplementationOfPriorityQueue {

    public static void main(String args[]) {
        PriorityQueue pq = new PriorityQueue();
        System.out.println(pq.peek());
        pq.push(45, 7);
        pq.push(33, 3);
        pq.push(11,57);
        pq.push(87, 13);
        System.out.println(pq.pop());
        pq.printQueue();
        pq.push(56, 9);
        pq.push(13, 8);
        pq.push(3,3);
        System.out.println(pq.peek());
        pq.pop();
        pq.printQueue();

    }

    static class PriorityQueue {

        class Node {
            Node next;
            int val;
            int priority;
        }

        Node head;

        public PriorityQueue() {
            head = new Node();
            head.next = null;
        }

        public void push(int x, int priority) {

            Node n = new Node();
            n.val = x;
            n.priority = priority;
            if(head.next == null) {
                head.next = n;
                n.next = null;
            } else {
                Node n2 = head.next;
                Node prev = head;
                while (n2 != null && n2.priority >= n.priority ) {
                    prev = n2;
                    n2 = n2.next;
                }
                prev.next = n;
                n.next = n2;
            }
        }

        public int pop() {
            if(head.next == null)
                return Integer.MIN_VALUE;

            int val = head.next.val;
            head = head.next;
            return val;
        }

        public int peek() {
            if(head.next == null)
                return Integer.MIN_VALUE;
            return head.next.val;
        }

        void printQueue() {
            Node n = head.next;
            while ( n!= null) {
                System.out.println("Item : "+ n.val+ " Priority : "+n.priority);
                n = n.next;
            }
        }
    }
}
