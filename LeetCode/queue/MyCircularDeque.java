package queue;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/18 20:38
 * @Description: 641. 设计循环双端队列 https://leetcode-cn.com/problems/design-circular-deque/
 **/
public class MyCircularDeque {
    private int capacity, size;
    Node front, last;

    public MyCircularDeque(int k) {
        this.size = 0;
        this.capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = last = newNode;
        } else {
            front.prev = newNode;
            newNode.next = front;
            front = front.prev;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = last.next;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (!isEmpty()) {
            Node destroy = front;
            front = front.next;
            destroy = null;
            size--;
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!isEmpty()) {
            Node destroy = front;
            last = last.prev;
            destroy = null;
            size--;
            return true;
        }
        return false;
    }

    public int getFront() {
        return this.size > 0 ? front.data : -1;
    }

    public int getRear() {
        return this.size > 0 ? last.data : -1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));                  // 返回 true
        System.out.println(circularDeque.insertLast(2));                  // 返回 true
        System.out.println(circularDeque.insertFront(3));                 // 返回 true
        System.out.println(circularDeque.insertFront(4));                 // 已经满了，返回 false
        System.out.println(circularDeque.getRear());                            // 返回 2
        System.out.println(circularDeque.isFull());                             // 返回 true
        System.out.println(circularDeque.deleteLast());                         // 返回 true
        System.out.println(circularDeque.insertFront(4));                 // 返回 true
        System.out.println(circularDeque.getFront());                           // 返回 4

//        MyCircularDeque circularDeque = new MyCircularDeque(8);
//        System.out.println(circularDeque.insertFront(5)); // true
//        System.out.println(circularDeque.getFront()); // 5
//        System.out.println(circularDeque.isEmpty());// false
//        System.out.println(circularDeque.deleteFront());// true
//        System.out.println(circularDeque.insertLast(4));//true
//        System.out.println(circularDeque.getRear());//4
//        System.out.println(circularDeque.insertLast(7));//true
//        System.out.println(circularDeque.insertFront(7));//true
//        System.out.println(circularDeque.deleteLast());//true
//        System.out.println(circularDeque.insertLast(4));//true
//        System.out.println(circularDeque.isEmpty());//flase
    }
}
