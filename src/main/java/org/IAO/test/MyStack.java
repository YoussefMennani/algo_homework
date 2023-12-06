package org.IAO.test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<Item> implements Iterable<Item>{

    Node<Item> first;
    int n;

    MyStack(){
        first = null;
        int n = 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new InterableStack(first);
    }

    private class InterableStack implements Iterator<Item>{

        public Node<Item> current;
        public InterableStack(Node<Item> first){
            current = first;
        }

        public boolean hasNext(){
            return current != null;
        }

        public Item next(){
            if (!hasNext()) throw new NoSuchElementException(" Empty");
            Item val = current.item;
            current = current.next;
            return val;
        }
    }

    private class Node<Item>{
        Item item;
        Node<Item> next;
    }

    public void push(Item newItem){
        Node oldNode = first;
        first = new Node();
        first.item = newItem;
        first.next = oldNode;
        n++;
    }

    public Item pop(){
        isValide();
        Item popItem = first.item;
        first = first.next;
        n--;
        return  popItem;
    }

    public void isValide(){
        if (first == null) throw new NoSuchElementException(" No such Element");
    }
    public Item peek(){
        return first.item;
    }

    public String toString(){

        StringBuilder s = new StringBuilder();

        for(Item i : this){
            s.append(i);
            s.append(" ");
        }
        return s.toString();
    }


    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(3);
        myStack.push(5);
        myStack.push(1);
        myStack.push(3);
        myStack.push(10);
        System.out.println(myStack.toString());
    }

}
