package stack;

/**
 * @Author: Mr.Z
 * @DateTime: 2020/12/24 13:33
 * @Description: This class implements a Stack using a regular array.
 *
 * <p>A stack is exactly what it sounds like. An element gets added to the top of the stack and only
 * the element on the top may be removed. This is an example of an array implementation of a Stack.
 * So an element can only be added/removed from the end of the array. In theory stack have no fixed
 * size, but with an array implementation it does.
 */
public class StackArray {
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The max size of the Stack
     */
    private int maxSize;

    /**
     * The array representation of the Stack
     */
    private int[] stackArray;

    /**
     * The top of the stack
     */
    private int top;

    /**
     * init Stack with DEFAULT_CAPACITY
     */
    public StackArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor
     *
     * @param size of the stack
     */
    public StackArray(int size) {
        maxSize = size;
        this.stackArray = new int[maxSize];
        top = top - 1;
    }

    /**
     * Add an element on the top of stack
     *
     * @param value the element added
     */
    public void push(int value) {
        if (!isFull()) {// Checks for a full stack
            top++;
            stackArray[top] = value;
        } else {
            resize(maxSize <<= 1);
            push(value);// don't forget push after resizing
        }
    }

    private void resize(int newSize) {
        int[] transferArray = new int[newSize];
        for (int i = 0; i < stackArray.length; i++) {
            transferArray[i] = stackArray[i];
        }
        // This reference change might be nice in here
        stackArray = transferArray;
        maxSize = newSize;
    }

    /**
     * Removes the top element of the stack and returns the value you've removed
     *
     * @return value popped off the Stack
     */
    public int pop() {
        if (!isEmpty()) {// Checks for an empty stack
            return stackArray[top--];
        }
        if (top < maxSize / 4) {
            resize(maxSize <<= 1);
            return pop();
        } else {
            System.out.println("This stack is already empty!");
            return -1;
        }
    }

    /**
     * Returns the element at the top of the stack
     *
     * @return element at the top of the stack
     */
    private int peek() {
        if (!isEmpty()) {
            return stackArray[top];
        } else {
            System.out.println("The stack is empty,can't peek.");
            return -1;
        }
    }

    /**
     * Returns true if the stack is empty
     *
     * @return
     */
    private boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Returns true if the stack is full
     *
     * @return
     */
    private boolean isFull() {
        return (top + 1 == maxSize);
    }

    /**
     * Deletes everything in the Stack
     *
     * <p>Doesn't delete elements in the array but if you call push method after calling makeEmpty it
     * will overwrite previous values
     */
    public void clear() {// Doesn't delete elements in the array but if you call
        top = -1;// push method after calling makeEmpty it will overwrite previous values
    }

    /**
     * Return size of stack
     *
     * @return size of stack
     */
    public int size() {
        return top + 1;
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Declare a stack of maximum size 4
        StackArray myStackArray = new StackArray(4);

        assert myStackArray.isEmpty();
        assert !myStackArray.isFull();

        // Populate the stack
        myStackArray.push(5);
        myStackArray.push(8);
        myStackArray.push(2);
        myStackArray.push(9);

        /**
         * use assert , need set VM options "-ea"
         */
        assert !myStackArray.isEmpty();
        assert myStackArray.isFull();
        assert myStackArray.peek() == 9;
        assert myStackArray.pop() == 9;
        assert myStackArray.peek() == 2;
        assert myStackArray.size() == 3;
    }
}
