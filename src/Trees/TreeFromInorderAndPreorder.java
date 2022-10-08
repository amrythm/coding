package Trees;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

//Construct Tree from given Inorder and Preorder traversals
public class TreeFromInorderAndPreorder {

    public static void main(String[] args) {
        String s1 = "ABDECF";
        String s2 = "DBEAFC";

        Node root = buildTree(s1,s2);

        print_preorder(root);
        System.out.println();
        print_inorder(root);
        System.out.println();
        print_postorder(root);

    }

    static class Node{
        Node left, right;
        char data;

        Node(char val) {
            this.data = val;
            left = right = null;
        }
    }
    public static Node buildTree(String pre_order, String in_order) {

        if(pre_order.length() != in_order.length())
            return null;

        if(pre_order.length() == 0)
            return null;

//        if(pre_order.length()== 1)
//            return new Node(pre_order.charAt(0));


        char root_data = pre_order.charAt(0);
        Node root = new Node(root_data);

        String left = "";
        int i = 0;
        while (in_order.charAt(i) != root_data) {
            left = left + in_order.charAt(i);
            i++;
        }
        String preorder_left = pre_order.substring(1,1+left.length());
        i++;
        String right = in_order.substring(i);
        String preorder_right = pre_order.substring(1+left.length());
        root.left = buildTree(preorder_left, left);
        root.right = buildTree(preorder_right, right);

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
