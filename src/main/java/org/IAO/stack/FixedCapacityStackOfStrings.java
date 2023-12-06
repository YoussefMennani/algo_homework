package org.IAO.stack;

public class FixedCapacityStackOfStrings {

    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int n){
        s = new String[n];
    }
    public boolean isEmpty(){
        return N == 0;
    }

    public void push(String item){
        s[N++] = item;
    }
    public String pop(){
        String deleteValue = s[--N];
        s[N] = null;
        return deleteValue;
    }

    public void display(){

        if(!isEmpty()) {
            for (int i = 0;i<N;i++){
                System.out.println(" index : "+i+" = "+s[i]);
            }
        }
    }

    public static void main(String[] args){
        FixedCapacityStackOfStrings stack_1 = new FixedCapacityStackOfStrings(10);
        stack_1.push("hello");
        stack_1.push("world");
        stack_1.push("mennani");

        stack_1.display();


        System.out.println(" element supprimée : "+  stack_1.pop());
        stack_1.display();

    }
}
