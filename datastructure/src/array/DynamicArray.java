package array;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Author: Mr.Z
 * @DateTime: 2020/12/24 9:52
 * @Description: dynamic array
 */
public class DynamicArray<E> implements Iterable<E> {

    private int size;
    private int capacity;
    private Object[] elements;


    /**
     * No-args constructor
     */
    public DynamicArray() {
        this.size = 0;
        this.capacity = 10;
        this.elements = new Object[this.capacity];
    }

    /**
     * constructor
     *
     * @param capacity the starting length of the desired array
     */
    public DynamicArray(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.elements = new Object[this.capacity];
    }

    /**
     * Adds an element to the array If full, creates a copy array twice the size of the current one
     *
     * @param element the element of type <E> to be added to the array
     */
    public void add(final E element) {
        if (this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, newCapacity());
        }
        this.elements[this.size] = element;
        size++;
    }

    /**
     * Doubles the capacity of the array
     *
     * @return int new capacity of the array
     */
    public int newCapacity() {
        // this.capacity *= 2;
        this.capacity <<= 1;
        return this.capacity;
    }

    /**
     * Places element of type <E> at the desired index
     *
     * @param index the index for the element to be placed
     * @param e     the element to be inserted
     */
    public void put(final int index, E e) {
        this.elements[index] = e;
    }

    /**
     * get method for element at a given index returns null if the index is empty
     *
     * @param index the desired index of the element
     * @return <E> the element at the specific index
     */
    public E get(final int index) {
        return getElement(index);
    }

    private E getElement(final int index) {
        return (E) this.elements[index];
    }

    /**
     * Remove an element from the array
     *
     * @param index the index of the element to be removed
     * @return <E> the element removed
     */
    public E remove(final int index) {
        final E oldElement = getElement(index);
        fastRemove(this.elements, index);
        return oldElement;
    }

    private void fastRemove(final Object[] elements, final int index) {
        final int newSize = this.size - 1;

        if (newSize > index) {
            System.arraycopy(elements, index + 1, elements, index, newSize - index);
        }

        elements[this.size = newSize] = null;
    }

    /**
     * get size from size field
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * get the capacity of DynamicArray
     *
     * @return
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * isEmpty helper method
     *
     * @return boolean true if the array contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * returns a String representation of this object
     *
     * @return String a String representing the array
     */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.stream(this.elements).filter(Objects::nonNull).toArray());
    }

    public Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    /**
     * Creates and returns a new Dynamic Array Iterator
     *
     * @return Iterator a Dynamic Array Iterator
     */
    @Override
    public Iterator iterator() {
        return new DynamicArrayIterator();
    }

    private class DynamicArrayIterator implements Iterator<E> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return this.cursor != size;
        }

        @Override
        public E next() {
            if (this.cursor > DynamicArray.this.size) throw new NoSuchElementException();

            if (this.cursor > DynamicArray.this.elements.length)
                throw new ConcurrentModificationException();

            final E element = DynamicArray.this.getElement(this.cursor);
            this.cursor++;

            return element;
        }

        @Override
        public void remove() {
            if (this.cursor < 0) throw new IllegalStateException();

            DynamicArray.this.remove(this.cursor);
            this.cursor--;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);

            for (int i = 0; i < DynamicArray.this.size; i++) {
                action.accept(DynamicArray.this.getElement(i));
            }
        }
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        DynamicArray<String> names = new DynamicArray<>();
        names.add("ZhangSan");
        names.add("ZhangSan");
        names.add("ZhangSan");
        names.add("ZhangSan");
        names.add("ZhangSan");
        names.add("ZhangSan");
        names.add("ZhangSan");
        names.add("ZhangSan");
        names.add("ZhangSan");
        names.add("ZhangSan");
        names.add("LiSi");

        for (String name : names) {
            System.out.println(name);
        }

        names.stream().forEach(System.out::println);

        System.out.println(names);
        System.out.println(names.getSize());
        System.out.println(names.getCapacity());
        System.out.println(names.isEmpty());
        names.remove(0);

        for (String name : names) {
            System.out.println(name);
        }
    }
}
