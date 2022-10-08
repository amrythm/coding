package Trees;


//The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes.
// The diagram below shows two trees each with diameter nine, the leaves that form the ends of the longest path are shaded
// (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
public class DiameterOfTree {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.right = new Node(9);
        root.right.right.right.left = new Node(10);
        root.right.right.right.left.right = new Node(11);
        root.right.right.right.right = new Node(12);
        System.out.println("Diameter " + findDiameter(root));

    }

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int findDiameter(Node root) {
        if(root == null)
            return 0;

        int ans = 1+ maxDistanceToLeaf(root.left) + maxDistanceToLeaf(root.right);
        int left = findDiameter(root.left);
        int right = findDiameter(root.right);
        return Math.max(ans, Math.max(left, right));
    }

    static int maxDistanceToLeaf(Node root) {
        if(root == null)
            return 0;

        return 1 +Math.max(maxDistanceToLeaf(root.left),maxDistanceToLeaf(root.right));
    }
}
