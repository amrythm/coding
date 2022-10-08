package LinkedLists;

public class IfTwoListsAreConnected {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {

        if(head1 == null || head2 == null)
            return null;

        ListNode n = head1;
        ListNode temp = head2;

        int countA =0;
        int countB = 0;

        while(n!= null) {
            countA++;
            n= n.next;
        }
        while(temp!= null) {
            countB++;
            temp = temp.next;
        }

        int count = Math.abs(countA - countB);
        n = head1;
        temp = head2;
        if(countA > countB) {
            int x = 0;

            while (x < count) {
                n = n.next;
                x++;
            }
        } else {
            int x = 0;
            while (x < count) {
                temp = temp.next;
                x++;
            }
        }
        while (n!= null) {
            if(n==temp)
                return n;
            n= n.next;
            temp = temp.next;
        }

        return null;

    }
}
