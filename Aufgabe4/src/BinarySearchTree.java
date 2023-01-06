public class BinarySearchTree {

        private Node root;
        private boolean hilfsParameterInsert;
        private boolean hilfsParameterRemove = true;
        // private boolean returnSearch = true;

        public BinarySearchTree() {
            root = null;
        }

        // Teil 1
// Insert-Method

        Node insert(int key, int value, Node root) {
            Node newNode = new Node(key, value);
            if (root == null) {                 //Wenn Key nicht Verwenden
                root = newNode;
                this.hilfsParameterInsert = true;
                if (this.root == null) {
                    this.root = root;
                }
            }
            else { //Suche nach Key wenn nicht gibt wird es eingefügt
                if (key < root.key) {
                    root.left = insert(key, value, root.left);
                } else if (key > root.key) {
                    root.right = insert(key, value, root.right);
                } else { // Wenn Key vorhanden
                    this.hilfsParameterInsert = false;
                    value = root.value;
                }
            }
            return root;
        }

        boolean insert(int value) {            //Hilfsmethode
            insert(value, value, this.root);
            return hilfsParameterInsert;
        }

        void preOrder(Node root) {
            if (root != null) {
                System.out.print(root.value + " ");
                preOrder(root.left);
                preOrder(root.right);
            }
        }

        void preOrder() {
            preOrder(this.root);
        }       // Hilfsmethode

        void inOrder(Node root) {
            if (root != null) {
                inOrder(root.left);
                System.out.print(root.value + " ");
                inOrder(root.right);
            }
        }
        void inOrder() {            //Hilfsmethode
            inOrder(this.root);
        }

        void postOrder(Node root) {
            if (root != null) {
                //Ausgabe des linken kindes
                postOrder(root.left);

                postOrder(root.right);

                System.out.print(root.value + " ");
            }
        }

        void postOrder() {          //Hilfsmethode
            postOrder(this.root);
        }

        boolean search(int key, int value, Node root) {
            if (root == null) {
                return false;
            } else if (key < root.key) {
                return search(key, value, root.left);

            } else if (key > root.key) {
                return search(key, value, root.right);
            } else {
                value = root.key;
                return true;
            }
        }

        public boolean search(int value) {          //Hilfsmethode
            return search(value, value, root);
        }

        //Teil 4
        // delete methode

        Node remove(int key, Node root) {
            if (root == null) {                         //Key nicht gefunden
                hilfsParameterRemove = false;
                return root;
            } else if(key < root.key) {                 // by-pass nach links
                root.left = remove(key,root.left);
            } else if (key > root.key) {                // by-pass nach rechts
                root.right = remove(key,root.right);
            }else if (root.left == null || root.right == null) { // 0&1 Kind
                root = (root.left != null) ? root.left : root.right;
            } else {                                    // Hat 2 Kinder ...
                Node min = new Node(key, root.value);
                root.right = searchMin(root.right, min);
                root.value = min.value;
                root.key = min.key;
            }
            return root;
        }

        public boolean remove(int key) {
            root = remove(key, root);
            return hilfsParameterRemove;
        }

        Node searchMin(Node root, Node min) {
            if (root.left == null) {
                min.key = root.key;
                min.value = root.value;
                root = root.right;
            } else  root.left = searchMin(root.left, min);
            return root;
        }
    }

