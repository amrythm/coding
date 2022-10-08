package BST;


import javax.swing.tree.TreeNode;

//Given a Singly Linked List which has data members sorted in ascending order.
// Construct a Balanced Binary Search Tree which has same data members as the given Linked List.
public class SortedLinkedListToBalancedBST {


    static class TreeNode{
        TreeNode left, right;
        int data;

        TreeNode(int data){
            this.data = data;
            left = right = null;
        }
    }

    static class ListNode{
        ListNode next;
        int data;

        ListNode(int data) {
            this.next = null;
            this.data = data;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;

        ListNode to_be_root = head;    // the value to be made root
        ListNode fast = head;          // the start of right subtree

        ListNode prev = null;

        // this loop is to get till mid element of list
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = to_be_root;
            to_be_root = to_be_root.next;
        }
        if(prev == null)                        // if prev is null here that means the
            return new TreeNode(head.data);     // list has only on e node, so return                                                   //that


        TreeNode root = new TreeNode(to_be_root.data);  // Make thr root node

        //break the link of the linked list to root
        // so now linkedlist pointed by head contains only nodes of the left subtree
        //so we can use that list to create the left subtree
        prev.next = null;
        root.left = sortedListToBST(head);

        //the linkedlist starting from next element of our root Node
        //can be used to create the left subtree
        ListNode right_subtree = to_be_root.next;
        root.right = sortedListToBST(right_subtree);

        return root;
    }
}
