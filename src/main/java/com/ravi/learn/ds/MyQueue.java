package com.ravi.learn.ds;

public class MyQueue<E> {
    private static int DEFAULT_QUEUE_SIZE = 10;
    private E[] myQueueArray = (E[]) new Object[DEFAULT_QUEUE_SIZE];
    private int size;
    private int firstInQueue = 0;
    private int lastInQueue = -1;

    public MyQueue() {
        this.size = this.DEFAULT_QUEUE_SIZE;
    }

    public MyQueue(int size) {
        if (size > 0 ) {
            this.size = size;
            myQueueArray = (E[]) new Object[size];
        }
    }

    public void enqueue(E data) {
        lastInQueue++;
        if (lastInQueue >= (size - 1)) {
            if (firstInQueue == 0) {
                this.size = this.size * 2 ;
                E[] dynamicQueue = (E[]) new Object[this.size];
                for ( int i = 0 ; i < myQueueArray.length ; i ++) {
                    dynamicQueue[i] = myQueueArray[i];
                }
                myQueueArray = dynamicQueue;
            } else {
                lastInQueue = lastInQueue % size ;
            }
        }
        myQueueArray[lastInQueue] = data;
    }

    public E dequeue() {
        E data = myQueueArray[firstInQueue];
        myQueueArray[firstInQueue] = null;
        firstInQueue++;
        if (firstInQueue >= size) {
            firstInQueue = firstInQueue % size;
        }
        return data;
    }

    static class MyQueueTest{
        public static void main(String... args) {
            MyQueue<String> myCircularQueue = new MyQueue<>(3);
            myCircularQueue.enqueue("Hello ");
            myCircularQueue.enqueue("WOrld1 !");
            myCircularQueue.enqueue("WOrld2 !");
            myCircularQueue.enqueue("WOrld3 !");
            myCircularQueue.enqueue("WOrld4 !");
            myCircularQueue.enqueue("WOrld5 !");
            myCircularQueue.enqueue("WOrld6 !");
            myCircularQueue.enqueue("WOrld7 !");
            myCircularQueue.enqueue("WOrld8 !");
            System.out.println(myCircularQueue.dequeue());
            System.out.println(myCircularQueue.dequeue());
            System.out.println(myCircularQueue.dequeue());
            System.out.println(myCircularQueue.dequeue());
            System.out.println(myCircularQueue.dequeue());
            System.out.println(myCircularQueue.dequeue());
            System.out.println(myCircularQueue.dequeue());
        }
    }

}
