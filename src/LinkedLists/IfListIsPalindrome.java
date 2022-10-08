package LinkedLists;

import java.util.Stack;

//Given a singly linked list of characters,
// write a function that returns true if the given list is a palindrome, else false.
public class IfListIsPalindrome {

    public static void main(String args[]) {

        Node head = new Node('1');
        head.next = new Node('2');
        head.next.next = new Node('2');
        head.next.next.next = new Node('1');
//        head.next.next.next.next = new Node('A');
//        head.next.next.next.next.next = new Node('R');

        /* Create a loop for testing */
        //head.next.next.next.next.next = head.next;

        System.out.println(isPalindrome(head));

    }

    static class Node {
        Node next;
        char val;
        Node(char val) {
            this.val = val;
            next = null;
        }
    }
    public static boolean isPalindrome(Node head) {
        if(head == null)
            return false;

        Stack<Character> s = new Stack<>();
        int size = 0;
        Node n = head;
        while (n!= null) {
            n = n.next;
            size++;
        }

        int begin = size/2 + 1;

        n = head;
        int counter = 1;
        while (counter < begin) {
            s.push(n.val);
            n = n.next;
            counter++;
        }
        if(size%2 != 0)
            n = n.next;

        while (n != null) {
            if(n.val != s.pop())
                return false;
            n = n.next;
        }
        return true;
    }

}
