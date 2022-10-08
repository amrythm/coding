package LinkedLists;

//Given a sorted doubly linked list of distinct nodes(no two nodes have the same data) and a value x.
// Count triplets in the list that sum up to a given value x.
public class CountTriplets {

    public static void main(String args[]) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev =head;

        head.next.next = new Node(4);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(5);
        head.next.next.next.prev = head.next.next;

        head.next.next.next.next = new Node(6);
        head.next.next.next.next.prev = head.next.next.next;

        head.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        head.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;


        System.out.println(countTriplets(head, 17));


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
    public static int countTriplets(Node head, int x) {
        if(head == null || head.next == null)
            return  0;

        int ans = 0;


        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node curr = head;
        while (curr != null) {
            int sum = x - curr.val;
            Node n = curr.next;
            if(curr == tail)
                break;
            Node n2 = tail;
            while (n.val < n2.val) {
                if (sum == n.val + n2.val) {
                    ans++;
                    n = n.next;
                    n2 = n2.prev;
                } else {
                    if (sum < (n.val + n2.val)) {
                        n2 = n2.prev;
                    } else {
                        n = n.next;
                    }
                }
            }
            curr = curr.next;
        }
        return  ans;
    }
}
