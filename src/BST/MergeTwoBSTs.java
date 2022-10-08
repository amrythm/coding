package BST;

public class MergeTwoBSTs {


    public static void main(String[] args) {

        Node root1 = new Node(100);
        root1.left = new Node(50);
        root1.right = new Node(300);
        root1.left.left = new Node(20);
        root1.left.right = new Node(70);


        Node root2 = new Node(80);
        root2.left = new Node(40);
        root2.right = new Node(120);

        Node merged = mergeBSTs(root1, root2);

        preorder(merged);

    }
    static class Node{
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int index = 0;

    public static Node mergeBSTs(Node root1, Node root2) {
        if(root1 == null && root2 == null)
            return null;
        if(root1 == null)
            return root2;
        if(root2 == null)
            return root1;

        int n1 = countNodes(root1);
        int n2 = countNodes(root2);

        int[] inorder1 = new int[n1];
        int[] inorder2 = new int[n2];

        fillInorder(root1, inorder1);
        index = 0;
        fillInorder(root2, inorder2);

        int res[] = mergeSortedArrays(inorder1, inorder2);

        return buildTree(res, 0, res.length-1);

    }

    private static int[] mergeSortedArrays(int[] a1, int[] a2) {

        int n1 = a1.length;
        int n2 = a2.length;
        int[] res = new int[n1+n2];

        int k = 0;
        int j=0, i=0;
        while (i<n1 && j<n2) {

            if(a1[i] < a2[j]) {
                res[k++] = a1[i++];
            } else res[k++] = a2[j++];
        }if(j==n2) {
            while ( i < n1) {
                res[k++] = a1[i++];
            }
        } else {
            while (j<n2)
                res[k++] = a2[j++];
        }

        return res;
    }

    private static void fillInorder(Node root, int[] a) {
        if(root == null)
            return;

        fillInorder(root.left,a);
        a[index++] = root.data;
        fillInorder(root.right, a);
    }

    private static Node buildTree( int[] a, int start, int end) {
        if(start>end)
            return null;

        int mid = (start+end)/2;
        Node root = new Node(a[mid]);
        root.left = buildTree(a,start, mid-1);
        root.right = buildTree(a, mid+1, end);

        return root;

    }

    private static int countNodes(Node root) {
        if(root == null)
            return 0;

        return 1+ countNodes(root.left) + countNodes(root.right);
    }

    public static void preorder(Node root) {
        if(root == null)
            return;

        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
    }
}
