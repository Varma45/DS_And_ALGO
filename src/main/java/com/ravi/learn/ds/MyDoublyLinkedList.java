package com.ravi.learn.ds;

public class MyDoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public MyDoublyLinkedList(){
        this.size = 0;
        this.head = this.tail = null;
    }

    public MyDoublyLinkedList(int data) {
        if (this.size == 0 ) {
            addFirst(data);
        }
    }

    public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " <->");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    public void addFirst(int data) {
        if (this.size==0) {
            this.head = new Node(data);
            this.tail = this.head;
        } else {
            Node firstNode = new Node(data);
            head.prev = firstNode;
            firstNode.next = head ;
            this.head = firstNode;
        }
        this.size++;
    }

    public void addLast(int data) {
        if (this.size == 0 ) {
            addFirst(data);
        } else {
            Node lastNode = new Node(data);
            tail.next = lastNode;
            lastNode.prev = tail;
            tail = lastNode;
        }
        this.size ++;
    }

    private Node getNodeAtIndex(int index) throws Exception{
        if (index == 0 ) return head;
        if (index == this.size - 1) return tail;

        if (index < 0 && index >= this.size) {
            throw new Exception("Invalid Index");
        }

        Node temp = this.head;
        for (int i = 0 ; i < index ; i ++) {
            temp = temp.next;
        }
        return temp;
    }

    public int getDataAtIndex(int index) throws Exception {
        return getNodeAtIndex(index).data;
    }

    public void addNodeAtIndex(int data, int index) throws Exception{
        if (index == 0) {addFirst(data);}
        else if (index == size) {addLast(data);}
        else {
            Node previousNode = getNodeAtIndex(index - 1);
            Node willBeAdded = new Node(data, previousNode);
            size++;
        }
    }

    public int deleteNodeAtIndex(int index) throws Exception {
        if (index < 0 && index >= size) throw new Exception("Invalid index");
        if (index == 0 ) {
            int value = this.head.data;
            this.head = this.head.next;
            this.head.prev = null;
            this.size--;
            return value;
        }
        if (index == size -1){
            int value = this.tail.data;
            tail = tail.prev;
            tail.next = null;
            return value;
        }
        Node currentNode = getNodeAtIndex(index);
        int value = currentNode.data;
        currentNode.next.prev = currentNode.prev;
        currentNode.prev.next = currentNode.next;
        this.size -- ;
        return value;

    }


    private class Node{
        private Node prev;
        private int data;
        private Node next;

        Node() {}
        Node(int data) {
            this.data = data;
        }
        Node(int data, Node previousNode) {
            this.prev = previousNode;
            this.data = data;
            previousNode.next.prev = this;
            this.next = previousNode.next;
            previousNode.next = this;
        }

    }

    private static class TestMyDLL{
        public static void main(String[] args) throws Exception {
            MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList();
            myDoublyLinkedList.addFirst(3);
            myDoublyLinkedList.addFirst(2);
            myDoublyLinkedList.addLast(1);
            myDoublyLinkedList.print();
            myDoublyLinkedList.addNodeAtIndex(0, 3);
            myDoublyLinkedList.print();
            System.out.println(myDoublyLinkedList.getDataAtIndex(1));
            //System.out.println(myDoublyLinkedList.deleteNodeAtIndex(3));
            myDoublyLinkedList.print();
            System.out.println(myDoublyLinkedList.deleteNodeAtIndex(2));
            myDoublyLinkedList.addNodeAtIndex(99, 2);
            myDoublyLinkedList.print();


        }
    }

}
