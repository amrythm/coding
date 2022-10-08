package LinkedLists;

//Given a singly linked list, swap kth node from beginning with kth node from end.
// Swapping of data is not allowed, only pointers should be changed.
// This requirement may be logical in many situations where the linked list data part is huge
// (For example student details line Name, RollNo, Address, ..etc). The pointers are always fixed
// (4 bytes for most of the compilers).
public class SwapKthNodesFromBeginingAndEnd {

    public static void main(String[] args) {


        Node head = new Node(1);
        head.next = new Node(2);

        head.next.next = new Node(3);

        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(7);

        /* Create a loop for testing */
        //head.next.next.next.next.next = head.next;
        printList(head);
        swap(head, 3);
        printList(head);
    }

    static class Node {
        Node next;
        int val;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    public static void swap(Node head, int k) {

        if(head == null)
            return;

        if(head.next == null)
            return;

        Node n = head;
        int size = 0;
        while (n!= null) {
            n = n.next;
            size++;
        }

        n = head;
        Node n2 = head;
        int count = 1;
        while (count < k-1){
            n = n.next;
            count++;
        }
        count = 1;
        while (count < size-k) {
            n2 = n2.next;
            count++;
        }

        Node temp1 = n.next;
        Node temp2 = n2.next;

        Node temp3 = n2.next.next;
        temp2.next = n.next.next;
        n.next = temp2;

        temp1.next = temp3;
        n2.next = temp1;

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
