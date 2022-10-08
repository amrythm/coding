package LinkedLists;

public class ReverseDoublyLinkedList {

    public static void main(String[] args) {


        Node head = new Node(1);
        Node n = new Node(2);
        head.next =n;
        n.prev = head;

        Node k = new Node(3);
        n.next = k;
        k.prev = n;

//        head.next.next.next = new Node(4);
//        head.next.next.next.next = new Node(5);
//        head.next.next.next.next.next = new Node(7);

        /* Create a loop for testing */
        //head.next.next.next.next.next = head.next;
        printList(head);
        reverse(head);
        printList(head);
    }

    public static void reverse(Node head) {
        if(head == null || head.next == null)
            return;

        Node temp = null;
        Node n = head;

        while (n!= null) {
            temp = n.prev;
            n.prev = n.next;
            n.next = temp;
            n = n.prev;
        }

        head = temp.prev;
    }

    static class Node {
        Node next;
        Node prev;
        int val;

        Node(int val) {
            this.val = val;
            next = prev = null;
        }
    }
    static  void printList(Node head) {
        if(head == null) {
            return;
        }
        Node n = head;

        while (n!= null) {
            System.out.print(n.val+" ");
            n = n.next;
        }
        System.out.println();
    }
}
