package BST;

public class AVLTreeImplementation {


    public static void main(String[] args) {

        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println(tree.balance(tree.root));

        tree.preOrder();
        tree.delete(30);
        System.out.println();
        tree.preOrder();

        System.out.println(tree.balance(tree.root));
        tree.insert(57);
        tree.insert(70);
        tree.insert(-11);
        tree.insert(63);
        tree.delete(101);
        tree.preOrder();
        System.out.println();
        System.out.println(tree.balance(tree.root));
    }


    static class Node<E extends Comparable<E>>{
        Node left, right;
        E data;

        Node(E data) {
            this.data = data;
            left = right = null;
        }
    }

    static class AVLTree<E extends Comparable<E>> {
        Node<E> root;

        AVLTree() {
            root = null;
        }
        AVLTree(E data) {
            root = new Node<>(data);
        }

        public void insert(E val) {
            if(root == null) {
                root = new Node<E>(val);
                return;
            }
            root = insert(root, val);
        }

        private Node<E> insert(Node<E> root, E val) {
            if(root == null) {
                return  new Node(val);
            }
            if(val.compareTo(root.data) < 0) {
                root.left = insert(root.left, val);
            } else root.right = insert(root.right, val);

            return  applyRotation(root);

        }

        public void delete(E val) {
            root = delete(root, val);
        }

        private Node<E> delete(Node<E> root, E val) {
            if(root == null)
                return  null;

            if(root.data.compareTo(val) >0)
                root.left = delete(root.left, val);
            else if (root.data.compareTo(val) < 0)
                root.right = delete(root.right, val);
            else {
                if(root.left != null && root.right != null) {
                    root.data = (E) getMax(root.left);
                    root.left = delete(root.left, root.data);
                } else if(root.right != null)
                    return root.right;
                else return root.left;
            }

            return applyRotation(root);
        }

        public E getMax(Node<E> root) {
            if(root == null)
                return null;

            Node<E> current = root;
            while (current.right != null)
                current = current.right;

            return current.data;
        }

        public E getMin(Node<E> root) {
            if(root == null)
                return null;

            Node<E> current = root;
            while (current.left != null)
                current = current.left;

            return current.data;
        }
        private int balance(Node<E> root) {
            return height(root.left) - height(root.right);
        }

        private int height(Node<E> root) {
            if(root == null)
                return  0;

            return 1 + Math.max(height(root.left),height(root.right));
        }

        private Node<E> applyRotation(Node<E> root) {
            if(root == null) {
                return null;
            }

            if(balance(root) > 1) {
                if(balance(root.left) < 0)
                    root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
            if(balance(root) < -1) {
                if(balance(root.right) > 0)
                    root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
            return root;
        }

        private Node<E> rightRotate(Node<E> root) {
            if(root == null)
                return null;

            Node<E> temp1 = root;
            Node<E> temp2 = root.left;
            temp1.left = temp2.right;
            temp2.right = temp1;

            return temp2;
        }

        private Node<E> leftRotate(Node<E> root) {
            if(root == null)
                return null;

            Node<E> temp1 = root;
            Node<E> temp2 = root.right;
            temp1.right = temp2.left;
            temp2.left = temp1;

            return temp2;
        }

        public void preOrder() {
            preOrder(root);
        }
        private void preOrder(Node<E> node) {
            if(node == null)
                return;

                System.out.print(node.data + " ");
                preOrder(node.left);
                preOrder(node.right);

        }
    }


}
