import java.util.Arrays;

public class BinarySearchTree {
    private class Node {
        int key;
        int val;
        Node left;
        Node right;
    }
    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree();

    }

    public boolean search(int key, int data, Node node) {
        if (node == null) {
            return false;
        } else if (key < node.key) {
            return search(key, data, node.left);
        } else if (key > node.key) {
            return search(key, data, node.right);
        } else {            // key gefunden
            data=node.val;
            return true;
        }
    }
    public boolean insert(int key, int data, Node node) {
        if (node == null) {    // key nicht vorhanden
            node=new Node();
            node.key=key;
            node.val=data;
            return true;
        } else if (key < node.key) {
            return insert(key, data, node.left);
        } else if (key > node.key) {
            return insert(key, data, node.right);
        } else {
            return false;   // key vorhanden
        }
    }
    Node searchMin(Node node) {
        if (node.left == null) {
            return node; // Minimum gefunden
        } else {
            return searchMin(node.left);
        }
    }
    public boolean remove(int key, Node p) {
        if (p == null) {
            return false; //key nicht gefunden
        } else if (key < p.key) {
            return remove(key, p.left);
        } else if (key > p.key) {
            return remove(key, p.right);
        } else if (p.left==null || p.right==null) { //0&1 Kind
            Node tmp = p;
            if (p.left!=null) {
                p=p.left; // by-pass nach links
            } else {
                p=p.right; // by-pass nach rechts
            }
            //delete tmp;???
            return true;
        } else {
            Node min = searchMin(p.right);
            p.val = min.val;
            p.key = min.key;
            return remove(min.key,p.right);
        }
    }

}
