package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InOrderWithoutRecursion {

    public static void main(String args[])
    {
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        print(root);
        inOrder(root);


    }
    static class Node {
        Node left, right;
        int val;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public static void inOrder(Node root) {

        if(root == null)
            return;

        Stack<Node> s = new Stack<>();
        Node current = root;

        while (!s.isEmpty() || current != null) {

            //current = s.peek();
            while (current != null) {
                s.push(current);
                current = current.left;
            }

            current = s.pop();
            //if(current != null)
            System.out.print(current.val +" ");


            current = current.right;
        }
    }

    static void print(Node root) {
        if(root == null)
            return;

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        Node temp;
        int counter = 0;
        int change_line = 1;
        while (!q.isEmpty()) {
            temp = q.poll();
            if(temp == null) {
                counter++;
                continue;
            }
            System.out.print(temp.val+" ");
            counter++;
            if(counter == change_line) {
                change_line = 2*change_line;
                counter = 0;
                System.out.println();
            }
            q.add(temp.left);
            q.add(temp.right);
        }
    }
}
