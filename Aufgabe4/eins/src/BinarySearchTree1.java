public class BinarySearchTree1 {


    private static class Node {
        int key;
        int data;
        Node left;
        Node right;

        public Node(int key, int data) {
            this.key = key;
            this.data = data;
        }
    }

    private Node root;

    public boolean insert(int key, int data) {
        root = insert(key, data, root);
        return true;
    }

    private Node insert(int key, int data, Node node) {
        if (node == null) {
            return new Node(key, data); // key nicht vorhanden
        }

        if (key < node.key) {
            node.left = insert(key, data, node.left);
        } else if (key > node.key) {
            node.right = insert(key, data, node.right);
        } else {
            // key is already in the tree, do not insert and return false
            return node;
        }
        return node;
    }

    public boolean remove(int key) {
        root = remove(key, root);
        return true;
    }

    private Node remove(int key, Node node) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = remove(key, node.left);
        } else if (key > node.key) {
            node.right = remove(key, node.right);
        } else {
            if (node.left == null && node.right == null) {
                // node is a leaf
                return null;
            } else if (node.left == null) {
                // node has only a right child
                return node.right;
            } else if (node.right == null) {
                // node has only a left child
                return node.left;
            } else {
                // node has two children
                Node minNode = findMin(node.right);
                node.key = minNode.key;
                node.data = minNode.data;
                node.right = remove(minNode.key, node.right);
            }
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public boolean search(int key) {
        return search(key, root);
    }

    private boolean search(int key, Node node) {
        if (node == null) {
            return false;
        }

        if (key == node.key) {
            return true;
        } else if (key < node.key) {
            return search(key, node.left);
        } else {
            return search(key, node.right);
        }
    }
    public static void main(String[] args) {
        BinarySearchTree1 searchTree = new BinarySearchTree1();
        searchTree.insert(5,1);
        searchTree.insert(3,2);
        searchTree.insert(7,3);
        searchTree.insert(2,4);
        searchTree.insert(4,5);
        System.out.println(searchTree.insert(2,2));
    }


//    private static class Node {
//        int key;
//        int data;
//        Node left;
//        Node right;
//
//        public Node(int key, int data) {
//            this.key = key;
//            this.data = data;
//        }
//    }
//
//    public boolean search(int key, int data, Node node) {
//        if (node == null) {
//            return false;
//        } else if (key < node.key) {
//            return search(key, data, node.left);
//        } else if (key > node.key) {
//            return search(key, data, node.right);
//        } else {            // key gefunden
//            data=node.data;
//            return true;
//        }
//    }
//    public boolean insert(int key, int data, Node parent) {
//        if (parent == null) {    // key nicht vorhanden
//            parent=new Node(key, data);
//            parent.key=key;
//            parent.data =data;
//            return true;
//        } else if (key < parent.key) {
//            return insert(key, data, parent.left);
//        } else if (key > parent.key) {
//            return insert(key, data, parent.right);
//        } else {
//            return false;   // key vorhanden
//        }
//    }
//    Node searchMin(Node node) {
//        if (node.left == null) {
//            return node; // Minimum gefunden
//        } else {
//            return searchMin(node.left);
//        }
//    }
//    public boolean remove(int key, Node node) {
//        if (node == null) {
//            return false; //key nicht gefunden
//        } else if (key < node.key) {
//            return remove(key, node.left);
//        } else if (key > node.key) {
//            return remove(key, node.right);
//        } else if (node.left==null || node.right==null) { //0&1 Kind
//            Node tmp = node;
//            if (node.left!=null) {
//                node=node.left; // by-pass nach links
//            } else {
//                node=node.right; // by-pass nach rechts
//            }
//            return true;
//        } else {
//            Node min = searchMin(node.right);
//            node.data = min.data;
//            node.key = min.key;
//            return remove(min.key,node.right);
//        }
//    }
}
