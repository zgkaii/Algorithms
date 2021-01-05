package stack;

import java.util.NoSuchElementException;

/**
 * @Author: Mr.Z
 * @DateTime: 2020/12/24 14:28
 * @Description: An implementation of a Stack using a Linked List
 */
class StackLinkedList {
    Node head;
    private int size;

    public StackLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Add element at top
     *
     * @param data to be added
     * @return true if add successfully
     */
    public boolean push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    /**
     * Pop element at top of stack
     *
     * @return element at top of stack
     * @throws NoSuchElementException if stack is empty
     */
    public int pop() {
        if (size == 0) {
            throw new NoSuchElementException("Empty stack,Nothing to pop!");
        }
        Node destroy = head;
        head = head.next;
        int retValue = destroy.data;
        destroy = null;// clear to let GC do it's work
        size--;
        return retValue;
    }

    /**
     * Peek element at top of stack
     *
     * @return element at top of stack
     * @throws NoSuchElementException if stack is empty
     */
    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("Empty stack. Nothing to pop!");
        }
        return head.data;
    }

    @Override
    public String toString() {
        Node tmp = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (tmp != null) {
            stringBuilder.append(tmp.data).append("->");
            tmp = tmp.next;
        }
        return stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "").toString();
    }

    /**
     * Check if stack is empty
     *
     * @return true if stack is empty, otherwise <tt>false</tt>
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return size of stack
     *
     * @return size of stack
     */
    public int getSize() {
        return size;
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);

        System.out.println("Size of stack currently is: " + stack.getSize());

        assert stack.pop() == 5;
        assert stack.pop() == 4;

        System.out.println("Top element of stack currently is: " + stack.peek());
    }
}

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}