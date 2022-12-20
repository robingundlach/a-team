public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(5,10,tree.root);
        tree.insert(3,20,tree.root);
        tree.insert(7,30,tree.root);
        tree.insert(2,40,tree.root);
        tree.insert(4,50,tree.root);
        tree.insert(6,60,tree.root);
        tree.insert(8,70,tree.root);

        System.out.println("Pre-order traversal:");
        tree.preOrder(tree.root);
        System.out.println("In-order traversal:");
        tree.inOrder(tree.root);
        System.out.println("Post-order traversal:");
        tree.postOrder(tree.root);
    }
}
