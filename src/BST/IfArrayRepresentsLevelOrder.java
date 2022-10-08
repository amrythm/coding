package BST;


//Given an array of size n.
// The problem is to check whether the given array can represent the level order traversal of a
// Binary Search Tree or not.

import java.util.LinkedList;
import java.util.Queue;

public class IfArrayRepresentsLevelOrder {

    public static void main(String args[])
    {
        int arr[] = {11, 6, 13, 5, 12, 10};
        if (canRepresentLevelOrder(arr))
            System.out.print( "Yes");
        else
            System.out.print( "No");

    }
    static class NodeDetails {
        int max_possible;
        int min_possible;

        int data;

        NodeDetails(int data) {
            this.data = data;
            max_possible = Integer.MAX_VALUE;
            min_possible = Integer.MIN_VALUE;
        }
    }

    public static boolean canRepresentLevelOrder(int[] a) {

        if(a.length == 0)
            return false;

        Queue<NodeDetails> q = new LinkedList<>();
        NodeDetails root = new NodeDetails(a[0]);
        q.add(root);
        int index = 1;
        while (index < a.length && !q.isEmpty()) {
            NodeDetails current = q.poll();
            NodeDetails temp = null;
            if(index < a.length && a[index] < current.data && a[index] > current.min_possible) {
                temp = new NodeDetails(a[index]);
                index++;
                temp.min_possible = current.min_possible;
                temp.max_possible = current.data;
                q.add(temp);
            }
            if(index < a.length && a[index] >= current.data && a[index] < current.max_possible) {
                temp = new NodeDetails(a[index]);
                index++;
                temp.min_possible = current.data;
                temp.max_possible = current.max_possible;
                q.add(temp);
            }
        }
        if(index == a.length)
            return true;
        return false;
    }
}
