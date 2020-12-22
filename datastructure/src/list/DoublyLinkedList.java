package list;

/**
 * @Author: Mr.Z
 * @DateTime: 2020/12/23 00:22
 * @Description: 双向链表
 **/
public class DoublyLinkedList {
    private Link head;
    private Link tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void insertHead(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            tail = newLink;
        }
        head.prev = newLink;
        newLink.next = head;
        head = newLink;
        ++size;
    }

    private void insertTail(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            head = newLink;
        }
        head.next = newLink;
        newLink.prev = tail;
        tail = newLink;
        ++size;
    }

    private void insertByIndex(int data, int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index:" + index + ",Size" + size);
        }
        if (index == 0) {
            insertHead(data);
        } else {
            if (index == size) {
                insertTail(data);
            }
            Link newLink = new Link(data);
            Link prevLink = head;
            for (int i = 0; i < index; i++) {
                prevLink = prevLink.next;
            }
            prevLink.next.prev = newLink;
            newLink.next = prevLink.next;
            newLink.prev = prevLink;
            prevLink.next = newLink;
        }
        ++size;
    }

    public DoublyLinkedList(int[] array) {
        if (array == null) throw new NullPointerException();
        for (int i : array) {
            insertTail(i);
        }
        size = array.length;
    }

    private boolean isEmpty() {
        return (head == null);
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