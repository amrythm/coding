package BST;


import Trees.TreeFromInorderAndPreorder;

import java.util.Stack;

//Given preorder traversal of a binary search tree, construct the BST.
public class BSTFromPreorderTraversal {

    public static void main(String[] args) {
        int[] a = {10, 5, 1, 7, 40, 50};

        //Node root = buildTree(a,0,a.length-1);
        Node root = buildTreeFaster(a);

        print_inorder(root);
        System.out.println();
        print_preorder(root);
        System.out.println();
        print_postorder(root);
    }

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

//// This method takes O(n*2) time
    static Node buildTree(int a[], int start, int end) {
        if(start > end)
            return  null;
        if(start == end)
            return  new Node(a[start]);

        Node root = new Node(a[start]);
        int change = start+1;
        while (change < end && root.data > a[change])
            change++;

            root.left = buildTree(a, start+1, change-1);

            root.right = buildTree(a, change, end);

        return root;
    }

    // Below Method takes O(N) time

    public static Node buildTreeFaster(int[] a) {
        if(a.length == 0)
            return null;

        Stack<Node> s = new Stack<>();
        Node root = new Node(a[0]);
        s.push(root);

        int i = 1;

        while (i<a.length) {
            Node temp = null;
            while (!s.isEmpty() && a[i] > s.peek().data) {
                temp = s.pop();
            }
            if(temp != null) {
                temp.right = new Node(a[i]);
                s.push(temp.right);
            } else {

                s.push(s.peek().left = new Node(a[i]));
            }
            i++;
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
