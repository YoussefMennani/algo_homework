package org.IAO.stack;

public class LinkedStackOfStrings {

    private Node first;
    private class Node{
        String item;
        Node next;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void push(String newItem){
        Node oldNode = first;
        first = new Node();
        first.item = newItem;
        first.next = oldNode;
    }

    public String pop(){
        String deletedItem = first.item;
        first = first.next;
        return  deletedItem;
    }

    public void showAll(){
        Node element = first;
        while (element!=null){
            System.out.println(" item : "+element.item);
            element= element.next;
        }
    }

    public  static void main(String[] args){
        LinkedStackOfStrings linkedStackOfStrings = new LinkedStackOfStrings();
        linkedStackOfStrings.push("hello");
        linkedStackOfStrings.push("world");
        linkedStackOfStrings.push("mennani");
        linkedStackOfStrings.showAll();

        linkedStackOfStrings.pop();

        linkedStackOfStrings.showAll();

    }
}
