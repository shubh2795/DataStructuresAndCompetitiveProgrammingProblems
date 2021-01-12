package trees;

public class BinarySearchTree {
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
        if (node == null) {
            System.out.println("\n");
            return;
        }
        inOrderTraversal(node.getRight());
        System.out.print(node.getVal() + " ");
        inOrderTraversal(node.getRight());

    }

    public void preOrderTraversal(Node node) {
        if (node == null) {
            System.out.println(" ");
            return;
        }
        System.out.print(node.getVal() + " ");
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    public void postOrderTraversal(Node node) {
        if (node == null) {
            System.out.println(" ");
            return;
        }
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.print(node.getVal() + " ");

    }


    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }
}
