package BST;

//Given Preorder traversal of a Binary Search Tree.
// Then the task is print leaf nodes of the Binary Search Tree from the given preorder.
public class PrintLeafNodes {

    public static void main(String[] args)
    {
        int preorder[] = {7,4,12,3,6,8,1,5,10};
        int n = preorder.length;
        printLeaves(preorder);
    }
    static class Node{
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int index = 0;
    static void printLeaves( int[] a) {

        printLeavesUtil(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean printLeavesUtil(int[] a, int min , int max) {
        if(index >= a.length)
            return false;


        if(a[index] > min && a[index] <= max) {
            index++;
            boolean left = printLeavesUtil(a, min, a[index - 1]);
            boolean right = printLeavesUtil(a, a[index - 1], max);

            if (!left && !right)
                System.out.print(a[index - 1] + " ");


            return true;
        }
        return false;
    }
}
