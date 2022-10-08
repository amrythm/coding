package LinkedLists;

//Given a doubly linked list, write a function to sort the doubly linked list in increasing order using merge sort.

public class MergeSort {

    public static void main(String[] args) {


        Node head = new Node(32);
        head.next = new Node(11);

        head.next.next = new Node(7);

        head.next.next.next = new Node(94);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(37);

        /* Create a loop for testing */
        //head.next.next.next.next.next = head.next;
        printList(head);
        printList(mergeSort(head));

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

    public static Node mergeSort(Node head){
        if(head == null || head.next == null)
            return head;

        Node slow_pointer = head;
        Node fast_pointer = head;

        while (fast_pointer.next != null && fast_pointer.next.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
        }

        Node mid = slow_pointer.next;
        slow_pointer.next = null;


            Node left = mergeSort(head);
            Node right = mergeSort(mid);
            Node sorted_list = merge(left, right);
            return sorted_list;
    }

    public static Node merge(Node head, Node mid) {
        if(head == null)
            return mid ;

        if(mid == null)
            return head;


        Node n = new Node(-1);
        Node k = n;
        while (head != null && mid != null) {
            if(head.val > mid.val) {
               k.next = mid;
               mid.prev = k;
               mid = mid.next;
            } else {
                k.next = head;
                head.prev = k;
                head = head.next;
            }
            k = k.next;
        } if(head == null) {
            while (mid != null) {
                k.next = mid;
                mid.prev = k;
                mid = mid.next;
                k = k.next;
            }
        }else  {
            while (head != null){
                k.next = head;
                head.prev = k;
                head = head.next;
                k = k.next;
            }
        }
        return n.next;
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
