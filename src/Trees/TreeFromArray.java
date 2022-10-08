package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeFromArray {

    public static void main(String args[]) {
        int a[] = {1,2,3,4,5,6,7};

        Node root = buildTree(a);

        print_inorder(root);
        System.out.println();
        print_postorder(root);
        System.out.println();
        print_preorder(root);
    }


    static class Node{
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left=right=null;
        }
    }
    static Node buildTree(int[] a) {
        if(a.length == 0)
            return null;

        Queue<Node> q = new LinkedList<>();
        Node root = new Node(a[0]);
        Node temp;
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i<a.length){
            temp = q.poll();
            temp.left = new Node(a[i++]);
            q.add(temp.left);
            temp.right = new Node(a[i++]);
            q.add(temp.right);
        }

        return root;
    }

    static void print_inorder(Node root) {
        if(root == null)
            return;

        print_inorder(root.left);
        System.out.print(root.data+" ");
        print_inorder(root.right);

    }

    static void print_preorder(Node root) {
        if(root == null)
            return;

        System.out.print(root.data+" ");
        print_preorder(root.left);
        print_preorder(root.right);

    }
    static void print_postorder(Node root) {
        if(root == null)
            return;

        print_postorder(root.left);
        print_postorder(root.right);
        System.out.print(root.data +" ");

    }
}
