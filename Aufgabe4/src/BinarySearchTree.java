public class BinarySearchTree {
    public Node root;

    private static class Node {
        int key;
        int value;
        Node left;
        Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Inserts a new key-value pair into the tree rooted at the specified node
    public boolean insert(int key, int value, Node node) {
        if (node == null) {
            return false;
        }

        if (key < node.key) {
            if (node.left == null) {
                node.left = new Node(key, value);
                return true;
            }
            return insert(key, value, node.left);
        } else if (key > node.key) {
            if (node.right == null) {
                node.right = new Node(key, value);
                return true;
            }
            return insert(key, value, node.right);
        } else {
            node.value = value;
            return true;
        }
    }

    // Performs a pre-order traversal of the tree rooted at the specified node
    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key + " " + node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Performs an in-order traversal of the tree rooted at the specified node
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key + " " + node.value);
            inOrder(node.right);
        }
    }

    // Performs a post-order traversal of the tree rooted at the specified node
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key + " " + node.value);
        }
    }

    // Searches the tree rooted at the specified node for a key-value pair with the specified key
    public boolean search(int key, int value, Node node) {
        if (node == null) {
            return false;
        }

        if (key < node.key) {
            return search(key, value, node.left);
        } else if (key > node.key) {
            return search(key, value, node.right);
        } else {
            return node.value == value;
        }
    }

    // Removes a key-value pair with the specified key from the tree rooted at the specified node
    public boolean remove(int key, Node node) {
        if (node == null) {
            return false;
        }

        // Find the node to remove
        Node current = node;
        Node parent = null;
        boolean isLeftChild = false;
        while (current.key != key) {
            parent = current;
            if (key < current.key) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        // Case 1: The node to remove has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // Case 2: The node to remove has one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        // Case 3: The node to remove has two children
        else {
            // Find the successor of the node to remove (the leftmost node in the right subtree)
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private Node getSuccessor(Node node) {
        Node parent = node;
        Node successor = node;
        Node current = node.right;
        while (current != null) {
            parent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != node.right) {
            parent.left = successor.right;
            successor.right = node.right;
        }
        return successor;
    }
}