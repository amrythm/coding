package Queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Given a binary tree, find its level order traversal.
//Level order traversal of a tree is breadth-first traversal for the tree.
public class BFSTreeTraversal {

    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    static ArrayList <Integer> levelOrder(Node node)
    {
        if(node == null)
            return null;

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList();

        list.add(node.data);

        while (node!=null) {
            if(node.left != null) {
                q.add(node.left);
                list.add(node.left.data);

            }

            if(node.right != null) {
                q.add(node.right);
                list.add(node.right.data);
            }
            node = q.poll();
        }

        return list;
    }

}
