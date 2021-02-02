package trees;

import java.util.LinkedList;
import java.util.Queue;

public class
BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }


    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    public Node insertRecursive(Node root, int val) {
        if (root == null)
            return new Node(val);
        if (root.getVal() < val)
            return insertRecursive(root.getRight(), val);
        else if (root.getVal() > val)
            return insertRecursive(root.getLeft(), val);
        else return root; //value already exists.
    }


    public boolean search(int val) {
        return searchRecursive(root, val);
    }

    public boolean searchRecursive(Node root, int val) {
        if (root == null)
            return false;
        if (root.getVal() == val)
            return true;
        return root.getVal() < val ? searchRecursive(root.getRight(), val) : searchRecursive(root.getLeft(), val);

    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getVal() + " ");
            inOrderTraversal(node.getRight());
        }
    }

    public void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.getVal() + " ");
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {

            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            System.out.print(node.getVal() + " ");
        }
    }

    public void levelOrderTraversal(Node node) {
        if (node != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                Node temp = queue.remove();
                System.out.print(temp.getVal() + " ");
                if (temp.getLeft() != null)
                    queue.add(temp.getLeft());
                if (temp.getRight() != null)
                    queue.add(temp.getRight());
            }
        }
    }


    public void levelOrderTraversal() {
        levelOrderTraversal(root);
        System.out.println("");
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
        System.out.println("");
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println("");
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
        System.out.println("");
    }
}
