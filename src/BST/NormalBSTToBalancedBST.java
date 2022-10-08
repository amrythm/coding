package BST;

import java.util.ArrayList;

// Covert a normal BST to a balanced BST
public class NormalBSTToBalancedBST {

    public static void main(String[] args) {

        Node root = new Node(6);
        root.left = new Node(5);
        root.left.left = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.left.left = new Node(2);
        root.left.left.left.left.left = new Node (1);


        System.out.println(height(root));
        root = balanceTree(root);
        //inorder(root);
        //System.out.println();
        System.out.println(height(root));
    }


    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int height(Node root) {
        if(root == null)
            return 0;

        int height_left = height(root.left);
        int height_right = height(root.right);
        return 1 + Math.max(height_left,height_right);
    }

    static Node balanceTree(Node root) {
        if(root == null)
            return root;

        ArrayList<Node> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        return balancedTree(inorder, 0 ,inorder.size()-1);
    }


   static Node balancedTree(ArrayList<Node> inorder, int start, int end) {

        if(start>end)
            return null;

        int mid = (start+end)/2;
        Node result = inorder.get(mid);
        result.left = balancedTree(inorder, start , mid-1);
        result.right = balancedTree( inorder, mid+1, end);

        return result;
    }
    static void inorderTraversal( Node root, ArrayList<Node> list) {
        if(root == null)
            return;

        inorderTraversal(root.left, list);
        list.add(root);
        inorderTraversal(root.right, list);

    }

    static void inorder( Node root) {
        if(root == null)
            return;

        inorder(root.left);
        System.out.println(root.data+ " ");
        inorder(root.right);

    }
}
