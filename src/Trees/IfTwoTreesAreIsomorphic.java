package Trees;

//Write a function to detect if two trees are isomorphic.
// Two trees are called isomorphic if one of them can be obtained from other by a series of flips,
// i.e. by swapping left and right children of a number of nodes. Any number of nodes at any level can
// have their children swapped. Two empty trees are isomorphic.

public class IfTwoTreesAreIsomorphic {


    static class Node{
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }

        static boolean areIsomorphic(Node root1, Node root2) {
            if(root1 == null && root2 == null)
                return true;
            if(root1 == null || root2 == null)
                return false;


            if(root1.data != root2.data)
                return false;

            boolean flipped = areIsomorphic(root1.left, root2.right)
                    && areIsomorphic(root1.right, root2.left);
            boolean same = areIsomorphic(root1.left, root2.left)
                    && areIsomorphic(root1.right, root2.right);

            return (flipped || same);
        }
    }
}
