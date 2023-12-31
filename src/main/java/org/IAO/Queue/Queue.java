package org.IAO.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The Queue class represents a first-in-first-out (FIFO)
 *  queue of generic items.
 *  It supports the usual enqueue and dequeue
 *  operations, along with methods for peeking at the first item,
 *  testing if the queue is empty, and iterating through
 *  the items in FIFO order.
 *  This implementation uses a singly linked list with a static nested class for
 *  linked-list nodes.
 *  operations all take constant time in the worst case.
 */
public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue

    int n;

    // develop Node class: helper linked list class

    private class Node<Item> {
        private Item item;
        private Node next;
    }


    /**
     * Constructor that initializes an empty queue.
     */

    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty.
     * <p>
     * return true if this queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this queue.
     * <p>
     * return the number of items in this queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns the item least recently added to this queue.
     * <p>
     * return the item least recently added to this queue
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException(" No such Element");
        return last.item;
    }

    /**
     * Adds the item to this queue.
     * <p>
     * item is the item to add
     */
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     * <p>
     * return the item on this queue that was least recently added
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException(" queue underFlow");
        Item item = first.item;
        first = first.next;
        n--;

        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    /**
     * Returns a string representation of this queue.
     * <p>
     * return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }


    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     * <p>
     * return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> fst){
            this.current = fst;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item myItem = current.item;
            current = current.next;
            return  myItem;
        }




    }


    /**
     * Unit tests the Queue data type.
     */
    public static void main(String[] args) {
        //  Develop the main method
    }
}

