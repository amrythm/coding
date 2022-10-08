package DynamicProgramming;

import java.util.ArrayList;

// Given a tree and a target element, find all the nodes at a distance k from that element
public class kthDistanceNodes {

    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        ArrayList<Integer> nodes = new ArrayList<>();

        findKthNodes(root, 22, 2, nodes);

        for (int i: nodes) {
            System.out.print(i+" ");
        }
    }

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void findKthChildrenNodes(Node root, int k, ArrayList<Integer> nodes) {
        if(root == null || k<0)
            return;

        if(k == 0)
            nodes.add(root.data);

        findKthChildrenNodes(root.left, k-1, nodes);
        findKthChildrenNodes(root.right, k-1, nodes);
    }

    public static int findKthNodes(Node root, int target, int k, ArrayList<Integer> nodes) {

        if(root == null)
            return -1;

        if(root.data == target) {
            findKthChildrenNodes(root, k, nodes);
            return 1;
        }

        int left_distance = findKthNodes(root.left, target, k, nodes);

        if(left_distance != -1) {

            if(left_distance == k)
                nodes.add(root.data);

            else // this is the case when the target is found at a distance less than k,
            // this means that the nodes in the other subtree might be at a distance k, so we check in the other subtree
            // but now the present root is at a distance of left_distance from target and the start node of the above subtree
            // is 1 distance from the root so total distance is 1+ left_distance, which the left subtree is away from the
            // target node. SO, we have to find the nodes in the other subtree which are at k - (left_distance +1) from
            // the start node of next subtree. If still not clear, please make tree and check, it will help
            findKthChildrenNodes(root.right, k- (left_distance +1), nodes);

            return 1+left_distance;
        }

        int right_distance = findKthNodes(root.right, target, k, nodes);

        if(right_distance != -1) {

            if(right_distance == k)
                nodes.add(root.data);

            else findKthChildrenNodes(root.left, k - (right_distance +1), nodes);
        }

        return -1;
    }
}
