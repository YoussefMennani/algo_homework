package org.IAO.homework.question4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    int n;

    // develop Node class: helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("No such Element");
        return last.item;
    }

    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underFlow");
        Item item = first.item;
        first = first.next;
        n--;

        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private static class LinkedIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> fst) {
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
            return myItem;
        }
    }

    public void mergeSortQueue() {
        first = mergeSort(first);
    }

    private Node<Item> mergeSort(Node<Item> node) {
        if (node == null || node.next == null) {
            return node;
        }
        // Split the list into two halves
        Node<Item> middle = getMiddle(node);
        Node<Item> nextOfMiddle = middle.next;
        middle.next = null;
        // Recursively sort each half
        Node<Item> left = mergeSort(node);
        Node<Item> right = mergeSort(nextOfMiddle);
        // Merge the sorted halves
        return merge(left, right);
    }

    private Node<Item> merge(Node<Item> left, Node<Item> right) {
        Node<Item> result = null;

        if (left == null) return right;
        else if (right == null) return left;

        else if (compare(left.item, right.item) <= 0) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    private Node<Item> getMiddle(Node<Item> node) {
        if (node == null) return node;

        Node<Item> slow = node, fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Replace this method with your own comparison logic if needed
    private int compare(Item item1, Item item2) {
        return ((Comparable<Item>) item1).compareTo(item2);
    }

    public static void main(String[] args) {
        Queue<Integer> myQueue = new Queue<>();
        myQueue.enqueue(5);
        myQueue.enqueue(6);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(4);
        myQueue.enqueue(3);



        System.out.println("Original Queue: " + myQueue);

        // Sorting the queue using Merge Sort
        myQueue.mergeSortQueue();

        System.out.println("Sorted Queue: " + myQueue);
    }
}
