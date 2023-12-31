package org.IAO.stack;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The ResizingArrayStack class represents a last-in-first-out (LIFO) stack
 *  of generic items.
 *  It supports the usual push and pop operations, along with methods
 *  for peeking at the top item, testing if the stack is empty, and iterating through
 *  the items in LIFO order.
 *  This implementation uses a resizing array, which double the underlying array
 *  when it is full and halves the underlying array when it is one-quarter full.
 *  The push and pop operations take constant amortized time.
 *  The size, peek, and is-empty operations takes
 *  constant time in the worst case.
 *  For additional documentation,
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    // initial capacity of underlying resizing array
    private static final int INIT_CAPACITY = 8;

    private Item[] a;         // array of items
    int n;


    /**
     * Initializes both an empty stack and the number of elements in the stack
     */
    public ResizingArrayStack() {
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }

    /**
     * Is this stack empty?
     * return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in the stack.
     *
     * @return the number of items in the stack
     */
    public int size() {
        return a.length;
    }


    // resize the underlying array holding the elements
    private void resize(int capacity) {
        if (capacity < n) return;

        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = a[i];
        }
        a = copy;

    }


    /**
     * Adds the item to this stack.
     * item is the item to add
     */
    public void push(Item item) {
        if (n == a.length) resize(2 * a.length);    // double size of array if necessary
        a[n++] = item;                            // add item
    }

    /**
     * Removes and returns the item most recently added to this stack.
     * return the item most recently added
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException(" Stack underflow");
        Item item = a[n - 1];
        a[n - 1] = null;                              // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == a.length / 4) resize(a.length / 2);
        return item;
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     * return the item most recently added to this stack
     */
    public Item peek() {
        return a[n - 1];
    }

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     * return an iterator to this stack that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;
        public ReverseArrayIterator() {
            i = n - 1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException(" unsupported Methode");
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException(" No such Element !");
            return a[i--];
        }
    }


    /**
     * Unit tests the Stack data type.
     */
    public static void main(String[] args) {
        //Develop the main method

    }
}


