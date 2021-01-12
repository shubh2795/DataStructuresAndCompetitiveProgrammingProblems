package trees;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(1);
        tree.root.setLeft(new Node(2));
        tree.root.setRight(new Node(3));
        tree.root.getLeft().setLeft(new Node(4));
        tree.root.getLeft().setRight(new Node(5));
        // tree.postOrderTraversal();
        tree.inOrderTraversal();



    }
}
