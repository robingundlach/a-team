public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert
        System.out.println(tree.insert(10));
        System.out.println(tree.insert(5));
        System.out.println(tree.insert(3));
        System.out.println(tree.insert(4));

        // Pre Order | In Order | Post Order
        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();
        System.out.println();

//        System.out.println(tree.deleteKey(9));
//        // System.out.println(tree.deleteKey(18)); // 18 wird zwar gelöscht aber 19 übernimmt den wert von 18
//        //System.out.println(tree.deleteKey(12));
//        //System.out.println(tree.deleteKey(4));
//        tree.preOrder();
//        System.out.println();
//        tree.postorder();
//        System.out.println();
//        System.out.println(tree.search(3));
//        System.out.println(tree.search(19));
//        // Hier wird der Fehler von Delete weitergeführt bei Search(19) -> 19 hat den wert 18 statt 19
//        //siehe bei tree.preorder() 18 ist immer noch da
//        //bei Search ist er aber entfernt worden heißt 18 wurde zwar entfernt aber 19 ist jetzt 18
//        System.out.println(tree.search(18));

    }
}