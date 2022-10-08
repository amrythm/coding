package BST;


import java.util.ArrayList;

//Given a binary tree and a key(node) value, find the floor and ceil value for that particular key value.
//
//Floor Value Node: Node with the greatest data lesser than or equal to the key value.
//Ceil Value Node: Node with the smallest data larger than or equal to the key value.
public class FloorANdCeilingForAKey {

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);

        for (int i: getFloorANdCeil(root,88)) {
            System.out.print(i+ " ");
        }
    }

    static class Node{
        Node right, left;
        int data;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static int[] getFloorANdCeil(Node root, int key) {
        int[] res = new int[2];
         find(root,key,res);
         return  res;

    }

    private static void find(Node root, int key, int[] res) {
        if(root == null) {
            if(res[0] > key)
                res[0] = -1;
            if(res[1] < key)
                res[1] = -1;
            return;
        }


        Node current = root;
        if(key == root.data) {
            res[0] = key;
            res[1] = key;
            return;
        }

        if(key < root.data) {
            res[1] = root.data;
            find(root.left, key, res);
        }
        else  {
            res[0] = root.data;
            find(root.right,key,res);
        }

    }
}
