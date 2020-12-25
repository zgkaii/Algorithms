package tree;

/**
 * @Author: Mr.Z
 * @DateTime: 2020/12/25 13:31
 * @Description: Binary Tree(二叉树)
 * <p>
 * This entire class is used to build a Binary Tree data structure. There is the Node Class and the
 * Tree Class, both explained below.
 * <p>
 * A binary tree is a data structure in which an element has two successors (children).The left child
 * is usually smaller than the parent,and the right child is usually bigger than the parent.
 */
public class BinaryTree {
    /**
     * The root of the Binary Tree
     */
    private Node root;

    /**
     * Constructor
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Method to find a Node with a certain value
     *
     * @param key Value being looked for
     * @return the node if it finds it, otherwise returns the parent
     */
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (key < current.data) {
                if (current.left == null) return current;// The key isn't exist, returns the parent
                current = current.left;
            } else if (key > current.data) {
                if (current.right == null) return current;
                current = current.right;
            } else {// find the value return it
                return current;
            }
        }
        return null;
    }

    /**
     * Inserts certain value into the Binary Tree
     *
     * @param data Value to be inserted
     * @return
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            // Return the soon to be parent of the value you're inserting(???)
            Node parent = find(data);

            // This if/else assigns the new node to be either the left or right child of the parent
            if (data < parent.data) {
                parent.left = newNode;
                parent.left.parent=parent;
                return;
            } else {
                parent.right=newNode;
                parent.right.parent=parent;
                return;
            }
        }
    }

    /**
     * Deletes a given value from the Binary Tree
     *
     * @param data Value to be deleted
     * @return If the value was deleted
     */
    public boolean remove(int data) {
        return true;
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}

/**
 * This class implements the nodes that will go on the Binary Tree. They consist of the data in
 * them, the node to the left, the node to the right, and the parent from which they came from.
 */
class Node {
    /**
     * Data from the node
     */
    public int data;
    /**
     * The Node to the left of this one
     */
    public Node left;
    /**
     * The Node to the right of this one
     */
    public Node right;
    /**
     * The parent of this node
     */
    public Node parent;

    /**
     * Constructor
     *
     * @param value
     */
    public Node(int value) {
        data = value;
        left = null;
        right = null;
        parent = null;
    }
}
