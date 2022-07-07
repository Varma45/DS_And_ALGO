package com.ravi.learn.ds;

import java.util.Stack;

public class MyStack<E> {

    private static int DEFAULT_SIZE = 10;
    private E[] stackArray = (E[]) new Object[DEFAULT_SIZE];
    private int size;
    private int ptr = -1;

    public MyStack(int size){
         if (size > 0) {
             stackArray = (E[]) new Object[size];
             this.size = size;
         }
    }

    //default constructor
    public MyStack() {
        this.size = this.DEFAULT_SIZE;
    }

    public void push(E data) {
        ptr++;
        if (ptr == size - 1) {
            this.size = this.size * 2 ;
            E[] dynamicStackArr = (E[]) new Object[size];
            for (int i = 0 ; i < stackArray.length ; i ++) {
                dynamicStackArr[i] = stackArray[i];
            }
            stackArray = dynamicStackArr;
        }
        stackArray[ptr] = data;
    }

    public E pop() throws Exception{
        if (ptr == -1) {
            throw new Exception("Stack is Empty");
        }
        E value = stackArray[ptr];
        ptr--;
        return value;
    }

    public E peek() throws Exception {
        if (ptr == -1) {
            throw new Exception("Stack is Empty");
        }
        return stackArray[ptr];
    }

    static class TestMyStack {
        public static void main(String[] args) throws Exception {
            MyStack<Integer> myDynamicStack = new MyStack<>(5);
            //myDynamicStack.peek();
            //myDynamicStack.pop();
            myDynamicStack.push(1);
            myDynamicStack.push(2);
            System.out.println(myDynamicStack.pop());
            System.out.println(myDynamicStack.peek());
            System.out.println(myDynamicStack.pop());
            //System.out.println(myDynamicStack.pop());
            myDynamicStack.push(3);
            myDynamicStack.push(4);
            myDynamicStack.push(5);
            myDynamicStack.push(6);
            myDynamicStack.push(7);
            myDynamicStack.push(8);
            myDynamicStack.push(9);
            myDynamicStack.push(10);
            myDynamicStack.push(11);
            System.out.println(myDynamicStack.peek());
            System.out.println(myDynamicStack.pop());
            System.out.println(myDynamicStack.pop());
            System.out.println(myDynamicStack.pop());
            System.out.println(myDynamicStack.pop());
            System.out.println(myDynamicStack.pop());
            System.out.println(myDynamicStack.pop());
            System.out.println(myDynamicStack.pop());
            System.out.println(myDynamicStack.pop());
            //System.out.println(myDynamicStack.pop());
            //System.out.println(myDynamicStack.pop());

            MyStack<String> myStack = new MyStack<>(5);
            myStack.push("Hellp");
            myStack.push("Helo");
            System.out.println(myStack.peek());
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());


        }
    }

}
