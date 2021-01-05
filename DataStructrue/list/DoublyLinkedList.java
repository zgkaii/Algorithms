package list;

/**
 * @Author: Mr.Z
 * @DateTime: 2020/12/23 00:22
 * @Description: 双向链表
 **/
public class DoublyLinkedList {
    /**
     * Head refers to the front of the list
     */
    private Link head;

    /**
     * Tail refers to the back of the list
     */
    private Link tail;

    /**
     * Size refers to the number of elements present in the list
     */
    private int size;

    /**
     * Default Constructor
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Constructs a list containing the elements of the array
     *
     * @param array the array whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public DoublyLinkedList(int[] array) {
        if (array == null) throw new NullPointerException();
        for (int i : array) {
            insertTail(i);
        }
        size = array.length;
    }

    /**
     * Insert an element at the head
     *
     * @param data Element to be inserted
     */
    public void insertHead(int data) {
        Link newLink = new Link(data);// Create a new link with a value attached to it
        if (isEmpty())
            tail = newLink;// Set the first element added to be the tail
        else
            head.prev = newLink;// newLink <-- tmp(head)
        newLink.next = head;// newLink <--> tmp(head)
        head = newLink;// newLink(head) <--> old head
        ++size;
    }

    /**
     * Insert an element at the tail
     *
     * @param data Element to be inserted
     */
    public void insertTail(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {// Check if there are no elements in list then it adds first element
            tail = newLink;
            head = tail;
        } else {
            tail.next = newLink; // tmp(tail) --> newLink
            newLink.prev = tail; // tmp(tail) <--> newLink
            tail = newLink; // old tail <--> newLink(tail)
        }
        ++size;
    }

    /**
     * Insert an element at the index
     *
     * @param data  Element to be inserted
     * @param index Index(from start) at which the element x to be inserted
     */
    public void insertByIndex(int data, int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index:" + index + ",Size" + size);
        }
        if (index == 0) {
            insertHead(data);
        } else {
            if (index == size) {
                insertTail(data);
            } else {
                Link newLink = new Link(data);
                Link prevLink = head;
                for (int i = 1; i < index; i++) {// loop to reach the index
                    prevLink = prevLink.next;// prevLink is the Link at index - 1 from start
                }
                prevLink.next.prev = newLink;// newLink <-- Link(index)
                newLink.next = prevLink.next;// newLink <--> Link(index)
                newLink.prev = prevLink;// Link(index-1) <-- newLink <--> Link(index)
                prevLink.next = newLink;// Link(index-1) <--> newLink <--> Link(index)
            }
        }
        ++size;
    }

    /**
     * Inserts element and reorders
     *
     * @param data Element to be added
     */
    public void insertOrdered(int data) {
        Link newLink = new Link(data);
        Link tmp = head;
        while (tmp != null && data > tmp.value) // Find the position to insert
            tmp = tmp.next;

        if (tmp == head) insertHead(data);
        else if (tmp == null) insertTail(data);
        else { // Before: 1 <--> 2(tmp) <--> 3
            newLink.prev = tmp.prev; // 1 <-- newLink
            tmp.prev.next = newLink; // 1 <--> newLink
            newLink.next = tmp; // 1 <--> newLink --> 2(tmp) <--> 3
            tmp.prev = newLink; // 1 <--> newLink <--> 2(tmp) <--> 3
        }
        ++size;
    }

    /**
     * Delete the element at the head
     *
     * @return new head
     */
    public Link deleteHead() {
        Link tmp = head;
        head = head.next;// old Head <--> 2ndElement(head)
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;// oldHead --> 2ndElement(head) nothing pointing at old head so will be removed
        }
        --size;
        return tmp;
    }

    /**
     * Delete the element at the tail
     *
     * @return new tail
     */
    public Link deleteTail() {
        Link tmp = tail;
        tail = tail.prev;// 2ndLast(tail) <--> oldTail --> null
        if (tail == null) {
            head = null;
        } else {
            tail.next = null; // 2ndLast(tail) --> null
        }
        --size;
        return tmp;
    }

    /**
     * Delete the element from somewhere in the list
     *
     * @param data element to be deleted
     */
    public void deleteByData(int data) {
        Link tmp = head;

        while (tmp.value != data) {// Find the position to delete
            if (tmp != tail) {
                tmp = tmp.next;
            } else {// If we reach the tail and the element is still not found
                throw new RuntimeException("The element to be deleted does not exist!");
            }
        }
        if (tmp == head)
            deleteHead();
        else if (tmp == tail)
            deleteTail();
        else {// Before: 1 <--> 2(tmp) <--> 3
            tmp.prev.next = tmp.next;// 1 --> 3
            tmp.next.prev = tmp.prev;// 1 <--> 3
        }
        --size;
    }

    /**
     * Deletes the passed node from the current list
     *
     * @param z Element to be deleted
     */
    public void deleteNode(Link z) {
        if (z.next == null) {
            deleteTail();
        } else if (z == head) {
            deleteHead();
        } else { // before <-- 1 <--> 2(z) <--> 3 -->
            z.prev.next = z.next; // 1 --> 3
            z.next.prev = z.prev; // 1 <--> 3
        }
        --size;
    }

    /**
     * Returns true if list is empty
     * @return true if list is empty
     */
    private boolean isEmpty() {
        return (head == null);
    }

    /**
     * Clears List
     */
    public void clearList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Prints contents of the list
     */
    public void display() {
        Link tmp = head;
        while (tmp != null) {
            tmp.displayLink();
            tmp = tmp.next;
        }
        System.out.println();
    }


    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insertHead(13);
        myList.insertHead(7);
        myList.insertHead(10);
        myList.display(); // <-- 10(head) <--> 7 <--> 13(tail) -->

        myList.insertTail(11);
        myList.display(); // <-- 10(head) <--> 7 <--> 13 <--> 11(tail) -->

        myList.deleteTail();
        myList.display(); // <-- 10(head) <--> 7 <--> 13(tail) -->

        myList.deleteByData(7);
        myList.display(); // <-- 10(head) <--> 13(tail) -->

        myList.insertOrdered(23);
        myList.insertOrdered(67);
        myList.insertOrdered(3);
        myList.display(); // <-- 3(head) <--> 10 <--> 13 <--> 23 <--> 67(tail) -->
        myList.insertByIndex(5, 1);
        myList.display(); // <-- 3(head) <--> 5 <--> 10 <--> 13 <--> 23 <--> 67(tail) -->
        myList.clearList();
        myList.display();
        myList.insertHead(20);
        myList.display();
    }
}

/**
 * This class is used to implement the nodes of the linked list.
 */
class Link {
    /**
     * Value of node
     */
    public int value;

    /**
     * This points to the link behind the new link
     */
    public Link next;

    /**
     * This points to the link in front of the new link
     */
    public Link prev;

    /**
     * Constructor
     *
     * @param value
     */
    public Link(int value) {
        this.value = value;
    }

    /**
     * Displays the node
     */
    public void displayLink() {
        System.out.print(value + " ");
    }
}