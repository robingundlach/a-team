public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert
        System.out.println(tree.insert(10));
        System.out.println(tree.insert(5));
        System.out.println(tree.insert(3));
        System.out.println(tree.insert(4));

        // Pre Order | In Order | Post Order
        System.out.println();
        tree.preOrder();
        System.out.println(" ");
        tree.inOrder();
        System.out.println(" ");
        tree.postOrder();
        System.out.println(" ");

        System.out.println("Delete 5: "+tree.remove(5));
        System.out.println("Search 5: "+tree.search(5));

    }
}