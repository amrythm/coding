package LinkedLists;

//You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order, and each of their nodes contains a single digit.
// Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//
//

public class AddingTwoNumbers {

    static class ListNode {
        ListNode next;
        int val;
        ListNode(){};
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode add(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode ans = root;
        int val , carry = 0;

        while (l1 != null && l2 != null) {

            val = l1.val + l2.val + carry;

            ListNode temp = new ListNode((val) % 10);
            carry = val / 10;

            root.next = temp;
            root = root.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l2 != null) {
            while (l2 != null) {
                ListNode temp;
                val = l2.val + carry;

                temp = new ListNode((val) % 10);
                carry = val / 10;

                root.next = temp;
                root = root.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            while (l1 != null) {
                val = l1.val + carry;

                ListNode temp = new ListNode((val) % 10);
                carry = val / 10;

                root.next = temp;
                root = root.next;
                l1 = l1.next;
            }
        }
        if (carry != 0) {
            ListNode temp = new ListNode(carry);
            root.next = temp;
        }

        return ans.next;
    }
}
