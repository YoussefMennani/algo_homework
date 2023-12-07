package org.IAO.homework.question2;

import org.IAO.stack.Stack;

public class StackSort{

    public static Stack<Integer> sort(Stack<Integer> stackToSort){
        Stack<Integer> auxStack = new Stack<>();

        Integer temp;

        while (!stackToSort.isEmpty()){

            temp = stackToSort.pop();
            while (!auxStack.isEmpty() && auxStack.peek() < temp ) {
                stackToSort.push(auxStack.pop());
            }
            auxStack.push(temp);
            }
        return auxStack;
    }


    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0;
    }

    public static void main(String[] args) {
        Stack<Integer> tab = new Stack<>();
        tab.push(1);
        tab.push(4);
        tab.push(8);
        tab.push(2);
        tab.push(4);
        tab.push(98);
        tab.push(2);

        Stack<Integer> newStack = new Stack<>();
        newStack = sort(tab);
        System.out.println(newStack.toString());
    }

}
