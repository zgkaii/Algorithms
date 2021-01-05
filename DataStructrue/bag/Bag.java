package bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author: Mr.Z
 * @DateTime: 2020/12/24 9:28
 * @Description: Collection which does not allow removing elements (only collect and iterate)
 */
public class Bag<Element> implements Iterable<Element> {
    private Node<Element> firstElement;// first element of bag
    private int size;// size of bag

    private static class Node<Element> {
        private Element content;
        private Node<Element> nextElement;
    }

    /**
     * Create an empty bag
     */
    public Bag() {
        firstElement = null;
        size = 0;
    }

    /**
     * @param element the element to add
     */
    public void add(Element element) {
        Node<Element> oldFirst = firstElement;
        firstElement = new Node<>();
        firstElement.content = element;
        firstElement.nextElement = oldFirst;
        size++;
    }

    /**
     * Check if the bag contains a specific element
     *
     * @param element which you want to look for
     * @return true if bag contains element ,otherwise false
     */
    public boolean contain(Element element) {
        Iterator<Element> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return an iterator that iterates over the elements in this bag in arbitrary order
     */
    public Iterator<Element> iterator() {
        return new ListIterator<>(firstElement);
    }

    @SuppressWarnings("hiding")// to suppress warnings relative to locals that hide variable
    private class ListIterator<Element> implements Iterator<Element> {
        private Node<Element> currentElement;

        public ListIterator(Node<Element> firstElement) {
            currentElement = firstElement;
        }

        public boolean hasNext() {
            return currentElement != null;
        }

        /**
         * remove is not allowed in a bag
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Element next() {
            if (!hasNext()) throw new NoSuchElementException();
            Element element = currentElement.content;
            currentElement = currentElement.nextElement;
            return element;
        }
    }

    /**
     * @return true if this bag is empty, false otherwise
     */
    public boolean isEmpty() {
        return firstElement == null;
    }

    /**
     * @return the number of elements
     */
    public int size() {
        return size;
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();

        bag.add("1");
        bag.add("1");
        bag.add("2");

        System.out.println("size of bag = " + bag.size());
        for (String s : bag) {
            System.out.println(s);
        }

        System.out.println(bag.contain(null));
        System.out.println(bag.contain("1"));
        System.out.println(bag.contain("3"));
    }
}
