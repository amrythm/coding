package BST;


//Given n appointments, find all conflicting appointments.
//
//Examples:
//
//Input: appointments[] = { {1, 5} {3, 7}, {2, 6}, {10, 15}, {5, 6}, {4, 100}}
//Output: Following are conflicting intervals
//[3,7] Conflicts with [1,5]
//[2,6] Conflicts with [1,5]
//[5,6] Conflicts with [3,7]
//[4,100] Conflicts with [1,5]
public class FindConflictingAppintments {

    public static void main(String[] args) {

        Node root = new Node(new Interval(1,5));
        root = insert(root, new Interval(3,7));
        root = insert(root, new Interval(2,6));
        root = insert(root, new Interval(10,15));
        root = insert(root, new Interval(5,6));
        root = insert(root, new Interval(4,100));
    }
    static class Interval {
        int high;
        int low;

        Interval(int low, int high) {
            this.high = high;
            this.low = low;
        }
    }

    static class Node {
        Interval interval;
        Node left, right;

        int max;

        Node(Interval i) {
            this.interval = i;
            this.max = i.high;
            left = null;
            right = null;
        }
    }

    static int height(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int balance(Node root) {
        if (root == null)
            return 0;

        return (height(root.left) - height(root.right));
    }

    public static Node insert(Node root, Interval i) {
        if (root == null) {
            root = new Node(i);
            return root;
        }

        if(overlap(root.interval, i))
            System.out.println(i.low+", "+i.high +" overlaps with "+ root.interval.low+", "+root.interval.high);

        if (root.interval.low > i.low) {
            root.left = insert(root.left, i);
        } else root.right = insert(root.right, i);



        root = applyRotate(root);
        if (root.max < i.high)
            root.max = i.high;

        return root;
    }

    private static boolean overlap(Interval i1, Interval i2) {
        if(i1 == null || i2 == null)
            return false;

        if(i1.low < i2.high && i2.low < i1.high)
            return true;

         return false;
    }

    private static Node applyRotate(Node root) {
        if (root == null)
            return null;

        if (balance(root) > 1) {
            if (balance(root.left) < 0)
                root.left = rotateLeft(root.left);
            root = rotateRight(root);
        } else if (balance(root) < -1) {
            if (balance(root.right) > 0)
                root.right = rotateRight(root.right);
            root = rotateLeft(root);
        }

        return root;
    }

    private static Node rotateRight(Node root) {
        if(root == null)
            return null;

        Node temp1 = root;
        Node temp2 = root.left;
        temp1.left = temp2.right;
        temp2.right = temp1;

        return temp2;
    }

    private static Node rotateLeft(Node root) {
        if(root == null)
            return null;

        Node temp1 = root;
        Node temp2 = root.right;
        temp1.right = temp2.left;
        temp2.left = temp1;

        return temp2;
    }
}


