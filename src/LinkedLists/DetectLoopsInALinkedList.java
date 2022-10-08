package LinkedLists;

public class DetectLoopsInALinkedList {

    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        /* Create a loop for testing */
        head.next.next.next.next.next = head.next;

        System.out.println("Number of nodes in the loop are " + countNodesInLoop(head));

    }

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }
    public static int countNodesInLoop(Node head) {

        Node slow_counter = head;
        Node fast_counter = head;

        while (fast_counter != null) {

            slow_counter = slow_counter.next;
            if(fast_counter.next != null) {
                fast_counter = fast_counter.next.next;
            } else break;

            if(slow_counter == fast_counter)
                break;
        }
        if(fast_counter != slow_counter)
            return 0;
        int count = 1;
        slow_counter = fast_counter.next;
        while (slow_counter != fast_counter) {
            slow_counter = slow_counter.next;
            count++;
        }
        return count;
    }
}
