package BST;

import java.util.ArrayList;

public class BSTFromLevelOrder {

    public static void main(String args[]) {
        int arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        int n = arr.length;

        Node root = buildTree(arr);

        System.out.print("Inorder Traversal: ");
        inorder(root);
    }


    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static Node buildTree(int arr[]) {

        Node root = new Node(arr[0]);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr) {
            list.add(i);
        }
        return buildTree(list);
    }

    static Node buildTree(ArrayList<Integer> list) {
        if(list.size() == 0)
            return null;

        Node root  = new Node(list.get(0));
        ArrayList<Integer> left_tree = new ArrayList<>();
        ArrayList<Integer> right_tree = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) < root.data)
                left_tree.add(list.get(i));
            else right_tree.add(list.get(i));
        }

        root.left = buildTree(left_tree);
        root.right = buildTree(right_tree);

        return root;
    }
    static void inorder(Node root) {
        if(root == null)
            return;

        inorder(root.left);
        System.out.print(root.data+ " ");
        inorder(root.right);
    }

}
