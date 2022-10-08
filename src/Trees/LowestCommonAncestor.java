package Trees;

//Given a binary tree (not a binary search tree) and two values say
// n1 and n2, write a program to find the least common ancestor.
public class LowestCommonAncestor {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " + findLCA(root,4, 5).data);
        System.out.println("LCA(4, 6) = " + findLCA(root,4, 6).data);
        System.out.println("LCA(3, 4) = " + findLCA(root,3, 4).data);
        System.out.println("LCA(2, 4) = " + findLCA(root ,2, 4).data);
    }


    static class Node{
        Node left, right;
        int data;

        Node(int data) {
            left=right=null;
            this.data = data;
        }
    }
    static Node findLCA(Node root, int n1, int n2) {
        if(root == null)
            return null;

        if(root.data == n1 || root.data == n2)
            return root;

        Node left_lca = findLCA(root.left, n1, n2);
        Node right_lca = findLCA(root.right, n1, n2);

        if(left_lca == null)
            return right_lca;
        if(right_lca == null)
            return left_lca;

        return root;
    }
}
