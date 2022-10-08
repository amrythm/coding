package BST;

//SOLUTION
//Create an array arr[] of size n, where n is the number of nodes in the given BST.
//Perform the inorder traversal of the BST and copy the node values in the arr[] in sorted order.
//Now perform the preorder traversal of the tree.
//While traversing the root during the preorder traversal, one by one copy the values from the array arr[] to the nodes.

public class BSTToMinHeap {

    public static void main(String[] args) {

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        covertToMinHeap(root);
        inOrder(root);

    }

    static class Node{
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static int index = 0;


    public static void covertToMinHeap(Node root) {
        if(root == null)
            return;

        int n = countNodes(root);
        int[] inorder = new int[n];

        fillInOrder(root, inorder);

        index = 0;
        fillMinHeap(root, inorder);
    }

    private static int countNodes(Node root) {
        if(root == null)
            return  0;

        return 1+ countNodes(root.left) + countNodes(root.right);
    }
    private static void fillInOrder(Node root, int[] a) {
        if(root == null)
            return;

        fillInOrder(root.left, a);
        a[index++] = root.data;
        fillInOrder(root.right, a);
    }

    private static void fillMinHeap(Node root, int[] a) {
        if(root == null)
            return;

        root.data = a[index++];
        fillMinHeap(root.left, a);
        fillMinHeap(root.right, a);
    }

    public static void inOrder(Node root) {
        if(root == null)
            return;


        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

}
