package BST;

import Trees.TreeFromInorderAndPreorder;

public class BSTImplementation {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.root = new Node(16);
        tree.insert(6);
        tree.insert(-5);
        tree.insert(33);
        tree.insert(7);
        tree.insert(63);
        tree.insert(38);
        tree.insert(55);
        tree.insert(69);
        tree.insert(16);
        tree.insert(11);
        tree.insert(28);
        tree.insert(-58);
        tree.insert(32);
        tree.insert(11);

        print_inorder(tree.root);
        System.out.println();
        print_preorder(tree.root);
        System.out.println();
        tree.delete(11);
        print_inorder(tree.root);
        System.out.println();
       System.out.println( tree.isPresent(11));
       System.out.println((tree.isPresent(17)));
       tree.delete(63);
       print_inorder(tree.root);
       System.out.println();
       tree.delete(16);
       print_inorder(tree.root);
       tree.delete(-58);
       System.out.println();
       print_inorder(tree.root);
    }


    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        void  insert(int val) {
            Node n = new Node(val);
            if(root == null) {
                root = n;
                return;
            }

            Node current = root;
            Node prev = null;
            while (current != null) {
                if(current.data > val) {
                    prev = current;
                    current = current.left;
                }
                else {
                    prev = current;
                    current = current.right;
                }
            }
            if(prev.data > val)
                prev.left = n;
            else prev.right = n;
        }

        boolean isPresent(int val) {

            Node current = root;
            while (current!= null) {
                if(current.data == val)
                    return true;
                if(current.data > val)
                    current = current.left;
                else current = current.right;
            }
            return false;
        }

        void delete (int val) {

            Node current = root;
            Node prev = null;
            while (current != null) {
                if(current.data == val)
                    break;
                if(current.data > val) {
                    prev = current;
                    current = current.left;
                }
                else {
                    prev = current;
                    current = current.right;
                }
            }
            if(current == null)
                return;
            if(current.right != null && current.left != null) {
                Node temp = current.left;
                Node prev_temp = null;
                while (temp.right != null) {
                    prev_temp = temp;
                    temp = temp.right;
                }
                current.data = temp.data;
                if(prev_temp == null)
                    current.left = temp.left;
                prev_temp.right = temp.left;

            }
            else {
                if(prev == null) {
                    root = null;
                }
                if (prev.data <= val)
                    prev.right = current.right;
                else prev.left = current.right;
            }

        }
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
