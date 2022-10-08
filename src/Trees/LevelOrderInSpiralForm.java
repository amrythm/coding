package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Write a function to print spiral order traversal of a tree.
public class LevelOrderInSpiralForm {

    public static void main(String args[])
    {
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        print(root);
        printSpirally(root);
    }


    static class Node {
        Node left, right;
        int data;

        Node (int val){
            data = val;
            left = right = null;
        }
    }
    static void printSpirally(Node root) {
        if(root == null)
            return;

        Stack<Node> s = new Stack<>();
        Stack <Node> s2 = new Stack<>();
        s.add(root);
        Node temp;
        while (!s.isEmpty() || !s2.isEmpty()) {

            while (!s.isEmpty()) {
                temp = s.pop();
                System.out.print(temp.data +" ");
                if(temp.right != null)
                    s2.push(temp.right);
                if(temp.left != null)
                    s2.push(temp.left);
            }
            while (!s2.isEmpty()) {
                temp = s2.pop();
                System.out.print(temp.data +" ");
                if(temp.left != null)
                    s.push(temp.left);
                if(temp.right != null)
                    s.push(temp.right);
            }
        }
        System.out.println();
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
            System.out.print(temp.data+" ");
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
