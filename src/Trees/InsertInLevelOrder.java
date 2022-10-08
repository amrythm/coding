package Trees;

import java.util.LinkedList;
import java.util.Queue;

//Given a binary tree and a key, insert the key into the binary tree at the first position available in level order.
public class InsertInLevelOrder {


    public static void main(String args[])
    {
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.println(
                "Inorder traversal before insertion:");
        inorder (root);

        int key = 12;
        insert(root, key);

        System.out.println(
                "\nInorder traversal after insertion:");
        inorder(root);

        delete(root,7);

        System.out.println(
                "\nInorder traversal after deletion:");
        inorder(root);
    }
    static class Node {
        Node left, right;
        int val;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static void insert(Node root, int val) {
        if(root == null){
            root = new Node(val);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if(temp.left == null) {
                temp.left = new Node(val);
                break;
            } else q.add(temp.left);
            if(temp.right == null) {
                temp.right = new Node(val);
                break;
            } else q.add(temp.right);
        }
    }

    static void delete(Node root, int val) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node key_node = null;
        Node temp = null;
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.val == val) {
                key_node = temp;
            }
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null)
                q.add(temp.right);
        }

        if (key_node == null) {
            System.out.println("Given value not present");
            return;
        }
        key_node.val = temp.val;
        q.clear();
        Node k = temp;
        q.add(root);
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp == k ) {
               temp = null;
               break;
            }
            if (temp.left != null) {
                if(temp.left == k) {
                    temp.left = null;
                    break;
                } else {
                    q.add(temp.left);
                }
            }
            if (temp.right != null) {
                if(temp.right == k) {
                    temp.right = null;
                    break;
                } else {
                    q.add(temp.right);
                }
            }
        }
    }


    static void inorder(Node root) {
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
