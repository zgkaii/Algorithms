package queue;

import java.util.NoSuchElementException;

/**
 * @Author: Mr.Z
 * @DateTime: 2020/12/24 15:39
 * @Description: LinkedQueue
 */
public class LinkedQueue {
    /**
     * Front of Queue
     */
    private Node front;

    /**
     * Rear of Queue
     */
    private Node rear;

    /**
     * Size of Queue
     */
    private int size;

    /**
     * Init LinkedQueue
     */
    public LinkedQueue() {
        front = rear = new Node();
    }

    /**
     * Check if queue is empty
     *
     * @return true if queue is empty, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return size of queue
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Peek element at the front of queue without removing
     *
     * @return element at the front
     */
    public int peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return front.next.data;
    }

    /**
     * Peek element at the rear of queue without removing
     *
     * @return element at the front
     */
    public int peekRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return rear.data;
    }

    /**
     * Add element to the queue.
     *
     * @param data insert value
     * @return true if add successfully
     */
    public boolean enqueue(int data) {
        Node newNode = new Node(data);
        rear.next = newNode;
        rear = newNode; /* make rear point at last node */
        size++;
        return true;
    }

    /**
     * Remove element at the front of queue
     *
     * @return element at the front of queue
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        Node destroy = front.next;
        int retValue = destroy.data;
        front.next = front.next.next;
        destroy = null;/* clear let GC do it's work */
        size--;
        if (isEmpty()) {
            front = rear;
        }
        return retValue;
    }

    /**
     * Clear all nodes in queue
     */
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuffer builder = new StringBuffer();
        Node tmp = front.next;
        builder.append("[");
        while (tmp != null) {
            builder.append(tmp.data).append(", ");
            tmp = tmp.next;
        }
        builder.replace(builder.length() - 2, builder.length(), "]");
        return builder.toString();
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        assert queue.isEmpty();

        queue.enqueue(1); /* 1 */
        queue.enqueue(2); /* 1 2 */
        queue.enqueue(3); /* 1 2 3 */
        System.out.println(queue); /* [1, 2, 3] */

        assert queue.size() == 3;
        assert queue.dequeue() == 1;
        assert queue.peekFront() == 2;
        assert queue.peekRear() == 3;

        queue.clear();
        assert queue.isEmpty();

        System.out.println(queue); /* [] */
    }
}

class Node {
    int data;
    Node next;
    Node prev;

    public Node() {
        this(0);
    }

    public Node(int data) {
        this(data, null, null);
    }

    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}