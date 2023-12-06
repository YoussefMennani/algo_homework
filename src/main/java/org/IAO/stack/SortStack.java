package org.IAO.stack;

public class SortStack {

    public static Stack<Integer> sortStack(Stack<Integer> input){

        Stack<Integer> tempStack = new Stack<>();
        while (!input.isEmpty()){
            Integer temp = input.pop();
            while (!tempStack.isEmpty() && temp > tempStack.peek()){
                input.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        return tempStack;
    }


    public static void main(String[] args) {

        Stack<Integer> input = new Stack<>();
        input.push(5);
        input.push(10);
        input.push(2);
        input.push(66);
        input.push(2);
        input.push(1);

        Stack<Integer> sortedStack = sortStack(input);
        System.out.println(sortedStack.toString());

    }
}
