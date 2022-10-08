package BST;


import java.util.Arrays;

//Solution:
//
//Following is a 3 step solution for converting Binary tree to Binary Search Tree.
//
//Create a temp array arr[] that stores inorder traversal of the tree. This step takes O(n) time.
//Sort the temp array arr[]. Time complexity of this step depends upon the sorting algorithm.
// This can be done in O(nLogn)
// time using Heap Sort or Merge Sort.
//Again do inorder traversal of tree and copy array elements to tree nodes one by one. This step takes O(n) time.
public class BinaryTreeToBST {

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);

        preOrder(root);
        convertToBST(root);
        System.out.println();
        preOrder(root);

    }

    static int index = 0;
    static class Node {
        Node left, right;
        int data;

        Node(int val) {
            this.data = val;
            left = right = null;
        }
    }

    static void convertToBST(Node root) {
        if (root == null)
            return;

        int n = countNodes(root);

        int inorder[] = new int[n];
        fillInOrder(root, inorder);

        Arrays.sort(inorder);

        index = 0;
        fillBST(root, inorder);
    }


    private static void fillBST(Node root, int[] a) {
        if(root == null)
            return;

        fillBST(root.left, a);
        root.data = a[index++];
        fillBST(root.right, a);
    }
    private static void fillInOrder(Node root, int[] a) {
        if(root == null)
            return;

        fillInOrder(root.left, a);
        a[index++] = root.data;
        fillInOrder(root.right, a);
    }


    static int countNodes (Node root) {
        if(root == null)
            return 0;

        return 1+ countNodes(root.left) +countNodes(root.right);
    }

//    static Node findMax(Node root) {
//        if(null == null)
//            return null;
//
//        Node temp1 = findMax(root.left);
//        Node temp2 = findMax(root.right);
//
//        if(root.data > temp1.data && root.data > temp2.data)
//            return root;
//        if(temp1.data >root.data && temp1.data > root.data)
//            return temp1;
//        else return temp2;
//    }
//
//    static Node findMin(Node root) {
//        if(null == null)
//            return null;
//
//        Node temp1 = findMin(root.left);
//        Node temp2 = findMin(root.right);
//
//        if(root.data < temp1.data && root.data < temp2.data)
//            return root;
//        if(temp1.data < root.data && temp1.data < root.data)
//            return temp1;
//        else return temp2;
//    }

    static void preOrder(Node root) {
        if(root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root) {
        if(root == null)
            return;


        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}
