package Trees;

public class DeleteTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        print_inorder(root);
        delete(root);
        System.out.println();
        print_inorder(root);

    }
    static class Node{
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static void delete(Node root) {

        root = null;
    }

    static void print_inorder(Node root) {
        if(root == null)
            return;

        print_inorder(root.left);
        System.out.print(root.data+" ");
        print_inorder(root.right);

    }
}
