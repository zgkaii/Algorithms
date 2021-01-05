package list;

import java.util.StringJoiner;

/**
 * @Author: Mr.Z
 * @DateTime: 2020/12/22 10:51
 * @Description: 单向链表
 */
public class SinglyLinkedList {
    /**
     * Head refer to the front of the list
     */
    private Node head;

    /**
     * Size of SinglyLinkedList
     */
    private int size;

    /**
     * Init SinglyLinkedList
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Init SinglyLinkedList with specified head node and size
     *
     * @param head
     * @param size
     */
    public SinglyLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    /**
     * Insert an element at the head of the list
     *
     * @param data
     */
    public void insertHead(int data) {
        insert(data, 0);
    }

    /**
     * Insert an element at the tail of the list
     *
     * @param data
     */
    public void insertTail(int data) {
        insert(data, size);
    }

    /**
     * Insert a new node at a specified position of the list
     *
     * @param data
     * @param position
     */
    public void insert(int data, int position) {
        checkBounds(position, 0, size);
        Node newNode = new Node(data);
        // the list is empty
        if (head == null) {
            head = newNode;
            size++;
            return;
        } else if (position == 0) {
            // insert at the head of the list
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        Node tmp = head;
        for (int i = 0; i < position - 1; i++) {
            tmp = tmp.next;
        }
        newNode.next = tmp.next;
        tmp.next = newNode;
        size++;
    }

    /**
     * Deletes a node at the head
     */
    public void deleteHead() {
        delete(0);
    }

    /**
     * Deletes an element at the tail
     */
    public void deleteTail() {
        delete(size - 1);
    }

    /**
     * Deletes an element at Nth position
     *
     * @param position
     */
    public void delete(int position) {
        checkBounds(position, 0, size - 1);
        if (position == 0) {
            Node destroy = head;
            head = head.next;
            destroy = null;
            size--;
            return;
        }
        Node tmp = head;
        for (int i = 0; i < position - 1; ++i) {
            tmp = tmp.next;
        }

        Node destroy = tmp.next;
        tmp.next = tmp.next.next;
        destroy = null; // clear to let GC do its work
        size--;
    }

    /**
     * if {@code position} not in range {@code low} to {@code high}
     *
     * @param position
     * @param low
     * @param high
     */
    public void checkBounds(int position, int low, int high) {
        if (position > high || position < low) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }

    /**
     * Checks if the list is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the size of the linked list
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Get head of the list.
     *
     * @return
     */
    public Node getHead() {
        return head;
    }

    /**
     * Clear all nodes in the list
     */
    public void clear() {
        Node tmp = head;
        while (tmp != null) {
            Node prev = tmp;
            tmp = tmp.next;
            prev = null;// clear to let GC do its work
        }
        head = null;
        size = 0;
    }

    /**
     * Calculate the count of the list manually
     *
     * @return count
     */
    public int count() {
        int count = 0;
        Node tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            count++;
        }
        return count;
    }

    /**
     * Test if the value key is present in the list.
     *
     * @param key
     * @return
     */
    public boolean search(int key) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.value == key) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    /**
     * Return element at special index.
     *
     * @param index
     * @return
     */
    public int getByIndex(int index) {
        checkBounds(index, 0, index - 1);
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.value;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("->");
        Node tmp = head;
        while (tmp != null) {
            joiner.add(tmp.value + "");
            tmp = tmp.next;
        }
        return joiner.toString();
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        assert list.isEmpty();
        assert list.size() == 0 && list.count() == 0;
        assert list.toString().equals("");

        /* Test insert function */
        list.insertHead(5);
        list.insertHead(7);
        list.insertHead(10);
        list.insertTail(3);
        list.insert(1, 4);
        assert list.toString().equals("10->7->5->3->1");

        /* Test search function */
        assert list.search(10) && list.search(5) && list.search(1) && !list.search(100);

        /* Test get function */
        assert list.getByIndex(0) == 10 && list.getByIndex(2) == 5 && list.getByIndex(4) == 1;

        /* Test delete function */
        list.deleteHead();
        list.delete(1);
        list.deleteTail();
        assert list.toString().equals("7->3");

        assert list.size == 2 && list.size() == list.count();

        list.clear();
        assert list.isEmpty();

        try {
            list.deleteTail();
            assert false; /* this should not happen */
        } catch (Exception e) {
            assert true; /* this should happen */
        }
    }
}

/**
 * This class is the nodes of the SinglyLinked list.
 * They consists of a value and a pointer to the node after them.
 */
class Node {
    /**
     * the value of the node
     */
    int value;

    /**
     * point to the next node
     */
    Node next;

    Node() {
    }

    /**
     * Constructor
     *
     * @param value value to be put in the node
     */
    Node(int value) {
        this(value, null);
    }

    /**
     * Constructor
     *
     * @param value value to be put in node
     * @param next  reference to the next node
     */
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
