package stack;

import java.util.Stack;

/**
 * @Author: Mr.Z
 * @DateTime: 2020/12/24 11:12
 * @Description: Implementation of a stack using nodes. Unlimited size, no arraylist.
 */
public class NodeStack<Item> {
    /**
     * Information each node should contain.
     *
     * @value item : information of the value in the node
     * @value head : the head of the stack
     * @value next : the next value from this node
     * @value previous : the last value from this node
     * @value size : size of the stack
     */
    private Item item;

    private static NodeStack<?> head;
    private NodeStack<?> next;
    private NodeStack<?> prev;
    private static int size = 0;

    /**
     * Constructors for the NodeStack.
     */
    public NodeStack() {
    }

    public NodeStack(Item item) {
        this.item = item;
    }

    /**
     * put a value onto the stack
     *
     * @param item value to be put on the stack.
     */
    public void push(Item item) {
        NodeStack<Item> newNodeStack = new NodeStack<>(item);
        if (this.isEmpty()) {
            NodeStack.setHead(new NodeStack<>(item));
            newNodeStack.setNext(null);
            newNodeStack.setPrev(null);
        } else {
            newNodeStack.setPrev(NodeStack.head);
            newNodeStack.setNext(newNodeStack);
            NodeStack.setHead(newNodeStack);
        }
        NodeStack.setSize(NodeStack.getSize() + 1);
    }

    /**
     * Value to be taken off the stack
     *
     * @return value that is returned.
     */
    public Item pop() {
        Item item = (Item) NodeStack.head.getData();
        NodeStack.setHead(NodeStack.head.getPrev());
        NodeStack.head.setNext(null);
        NodeStack.setSize(NodeStack.getSize() - 1);
        return item;
    }

    /**
     * Value that is next to be taken off the stack.
     *
     * @return item : the next value that would be popped off the stack.
     */
    public Item peek() {
        return (Item) NodeStack.head.getData();
    }

    /**
     * If the stack is empty or there is a value in.
     *
     * @return boolean : whether or not the stack has anything in it.
     */
    public boolean isEmpty() {
        return NodeStack.getSize() == 0;
    }

    /**
     * Print the contents of the stack in the following format.
     *
     * <p>x <- head (next out) y z <- tail (first in) . . .
     */
    private void print() {
        for (NodeStack<?> nodeStack = NodeStack.head; nodeStack != null; nodeStack = nodeStack.prev) {
            System.out.println(nodeStack.getData().toString());
        }
    }

    /**
     * Getters and setters (private)
     */
    private Item getData() {
        return this.item;
    }

    public static NodeStack<?> getHead() {
        return head;
    }

    public static void setHead(NodeStack<?> head) {
        NodeStack.head = head;
    }

    public NodeStack<?> getNext() {
        return next;
    }

    public void setNext(NodeStack<?> next) {
        this.next = next;
    }

    public NodeStack<?> getPrev() {
        return prev;
    }

    public void setPrev(NodeStack<?> prev) {
        this.prev = prev;
    }

    private static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        NodeStack.size = size;
    }

    /**
     * Returns the size of the stack.
     *
     * @return int : number of values in the stack.
     */
    public int size() {
        return NodeStack.getSize();
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        NodeStack<Integer> nodeStack = new NodeStack<Integer>();
        nodeStack.push(3);
        nodeStack.push(4);
        nodeStack.push(5);
        System.out.println("Testing :");
        nodeStack.print(); // prints : 5 4 3

        Integer x = nodeStack.pop(); // x = 5
        nodeStack.push(1);
        nodeStack.push(8);
        Integer y = nodeStack.peek(); // y = 8
        System.out.println("Testing :");
        nodeStack.print(); // prints : 8 1 4 3

        System.out.println("Testing :");
        System.out.println("x : " + x);
        System.out.println("y : " + y);
    }
}
