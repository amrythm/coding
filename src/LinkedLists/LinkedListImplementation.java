package LinkedLists;


// Own implementation of linkedlists

import Queues.LinkedListImplementationOfPriorityQueue;

public class LinkedListImplementation {

    public static void main(String args[]) {
        MyLinkedList list = new MyLinkedList();
        list.delete(5);
        list.add(5);
        list.add(7);
        System.out.println("Size : " +list.getSize());
        list.add(11);
        System.out.println(list.pop());
        System.out.println(list.peek());
        System.out.println("Size : " +list.getSize());
        list.printList();
        list.add(32);
        list.add(54);
        list.add(22);
        list.add(1);
        list.add(16);
        list.printList();
        list.add(30);
        list.remove(32);
        list.remove(67);
        list.delete(list.getSize());
        list.printList();

    }

    static class Node {
        Node next;
        int val;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    public static class MyLinkedList {

        Node head;
        int size;

        MyLinkedList() {
            head = null;
            size = 0;
        }
        MyLinkedList(Node n) {
            head = n;
            while (n != null) {
                n = n.next;
                size++;
            }
        }
        MyLinkedList(int val) {
            head = new Node(val);
            size++;
        }

        public void add(int val) {
            if(head == null) {
                head = new Node(val);
            } else {
                Node n = head;
                while (n.next != null) {
                    n = n.next;
                }
                Node temp = new Node(val);
                n.next = temp;
            }
            size++;
        }

        int pop() {
            if(size == 0)
                return Integer.MIN_VALUE;
            int val = head.val;
            head = head.next;
            size--;
            return val;
        }

        int peek() {
            if(size == 0)
                return Integer.MIN_VALUE;
            return head.val;
        }
        int getSize(){
            return size;
        }

        void remove( int val) {
            if(size == 0)
                return;

            if(head.val == val)
                head = head.next;
            else {
                Node n = head;
                while (n.next != null && n.next.val != val) {
                    n = n.next;
                }
                if(n.next == null) {
                    System.out.println("Value not present in the list");
                    return;
                }
                n.next = n.next.next;
            }
            size--;
        }

        void delete(int pos) {
            if(pos > size) {
                System.out.println("This position is out of bounds!!!");
                return;
            }
            int count = 1;
//            if(pos == 1)
//                head = head.next;
            Node n = head;
            while (count < pos-1) {
                n = n.next;
                count++;
            }
            n.next = n.next.next;
        }

        void printList() {
            if(size == 0)
                return;

            Node n = head;
            while (n!= null) {
                System.out.print(n.val+" ");
                n = n.next;
            }
            System.out.println();
        }

    }
}
