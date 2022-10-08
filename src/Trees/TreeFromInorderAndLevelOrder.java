package Trees;

import java.util.ArrayList;
import java.util.HashSet;

public class TreeFromInorderAndLevelOrder {

    public static void main(String[] args) {

        int[] inorder   = {4, 8, 10, 12, 14, 20, 22};
        int[] level = {20, 8, 22, 4, 12, 10, 14};
        Node root = buildTree(inorder, level);

        print_inorder(root);
        System.out.println();
        print_postorder(root);
        System.out.println();
        print_preorder(root);
    }

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            left = right = null;
            this.data = data;
        }
    }

    static Node buildTree(int[] inorder, int[] levelorder) {
        if(inorder.length != levelorder.length || inorder.length == 0)
            return null;

        Node root = new Node(levelorder[0]);
       // levelorder[0] = -1;
        int root_data = root.data;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        int i = 0;
        while (inorder[i] != root_data) {
            left.add(inorder[i]);
            i++;
        }
        i++;
        while (i<inorder.length) {
            right.add(inorder[i]);
            i++;
        }

        root.left = buildTreeUtil( levelorder, left);
        root.right = buildTreeUtil( levelorder, right);

        return root;
    }

    static Node buildTreeUtil( int[] levelorder, ArrayList<Integer> inorder) {
        if(inorder.size() == 0)
            return null;

        int i = 1;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        while (!inorder.contains(levelorder[i])) {
            i++;
        }

        Node temp = new Node(levelorder[i]);
        //levelorder[i] = -1;
        int temp_data = temp.data;
        i = 0;
        while (inorder.get(i) != temp_data) {
            left.add(inorder.get(i));
            i++;
        }
        i++;
        while (i<inorder.size()) {
            right.add(inorder.get(i));
            i++;
        }

        temp.left = buildTreeUtil(levelorder, left);
        temp.right = buildTreeUtil(levelorder, right);

        return temp;
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
