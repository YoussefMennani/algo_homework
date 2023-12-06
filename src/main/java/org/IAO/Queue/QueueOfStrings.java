package org.IAO.Queue;

public class QueueOfStrings {

    public Node first,last;
    int n= 0;
    private class Node{
        String item;
        Node next;
    }


    public void enqueue(String item){

        Node oldLast  = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty()) first = last;
        else oldLast.next = last;

        n++;
    }

    public String dequeue(){
        String item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        n--;
        return item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }

    public void display(){
        Node el = first;
        while (el != null){
            System.out.println(" Val : "+el.item);
            el = el.next;
        }
    }

    public static void main(String[] args) {

        QueueOfStrings queueOfStrings = new QueueOfStrings();
        queueOfStrings.enqueue("1");
        queueOfStrings.enqueue("2");
        queueOfStrings.enqueue("3");
        queueOfStrings.enqueue("4");
        queueOfStrings.enqueue("5");

        queueOfStrings.display();

        System.out.println(" ------------------------------  n = "+queueOfStrings.size());
        queueOfStrings.dequeue();
        queueOfStrings.dequeue();
        queueOfStrings.dequeue();
        queueOfStrings.display();
        System.out.println(" ------------------------------  n = "+queueOfStrings.size());
    }
}
