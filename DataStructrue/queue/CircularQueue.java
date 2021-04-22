package queue;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/04/22 21:45
 * @Description: CircularQueue
 **/
public class CircularQueue {
    /**
     * The Array representing the queue
     */
    private String[] items;
    /**
     * Max size of queue
     */
    private int maxSize = 0;
    /**
     * Front of queue
     */
    private int head = 0;
    /**
     * Rear of queue
     */
    private int tail = 0;

    /**
     * Constructor
     *
     * @param capacity
     */
    public CircularQueue(int capacity) {
        items = new String[capacity];
        maxSize = capacity;
    }

    /**
     * Inserts an element to the queue
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        // Returns false if the queue is full
        if ((tail + 1) % maxSize == head)
            return false;
        items[tail] = item;
        tail = (tail + 1) % maxSize;
        return true;
    }

    /**
     * Remove an element from the queue
     *
     * @return
     */
    public String dequeue() {
        // if head == tail means the queue is empty
        if (head == tail) return null;
        String ret = items[head];
        head = (head + 1) % maxSize;
        return ret;
    }
}
