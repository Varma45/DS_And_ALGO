package com.ravi.learn.ds;

public class MySinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public MySinglyLinkedList() {
    }

    public MySinglyLinkedList(int value) {
        insertHead(value);
    }

    private void insertHead(int value) {
        Node first = new Node(value);
        this.head = first;
        this.tail = first;
        this.size = 1;
    }

    public void insertAtFirst(int value) {
        Node newFirstNode = new Node(value);
        newFirstNode.next = this.head;
        this.head = newFirstNode;
        this.size++;
    }


    /**
     * Inserts node at the position specified
     *
     * @param nodeValue
     * value of node
     * @param position
     * position where new node needs to be inserted
     */
    public void insertAt(int nodeValue, int position) throws Exception {
        if (position < 0 || position > size) {
            throw new Exception("Invalid Position: " + position);
        }

        if (position == 0 ) {
            insertAtFirst(nodeValue);
            return;
        }
        if (position == size) {
            insertAtLast(nodeValue);
            return;
        }


        // at first temp is at head -> 0
        Node temp = head;
        // as temp is already at 0 iterate from 0 till position - 1
        // position - 1 node points to new node and new node points to previous position node
        for (int i = 1 ; i < position; i ++) {
            temp = temp.next;
        }
        Node newNode = new Node(nodeValue);
        newNode.next = temp.next;
        temp.next = newNode;
        // instead above can directly use the new BinarySearchNode(nodeValue, temp) ->
        //as that will auto map the pointers
        size++;

    }


    public void insertAtLast(int value) {
        if (this.head == null) {
            insertHead(value);
        } else {
            Node latestNode = new Node(value);
            this.tail.next = latestNode;
            this.tail = latestNode;
            this.size++;
        }
    }

    public int getValueAt(int index) throws Exception {
        Node nodeAtIndex = getNodeAtIndex(index);
        return nodeAtIndex.value;
    }

    public Node getNodeAtIndex(int index) throws Exception {
        if (index == 0 ) {
            return head;
        }
        if (index == size - 1) {
            return tail;
        }
        if(index < 0 || index >= size) {
            throw new Exception("Invalid index position");
        }

        Node temp = head;
        for (int i = 1 ; i <= index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int deleteNodeAtIndex(int index) throws Exception {
        if (index == 0 ) {
            return deleteFirstNode();
        }

        if (index == size -1 ) {
            return deleteLastNode();
        }

        Node previousNode = getNodeAtIndex(index-1);
        Node toBeDeleted = previousNode.next;
        int value = toBeDeleted.value;
        previousNode.next = previousNode.next.next;
        toBeDeleted = null;
        size--;
        return value;
    }

    public int deleteLastNode() throws Exception {
        Node prevToLastNode = getNodeAtIndex(size - 2);
        int value = tail.value;
        tail = prevToLastNode;
        tail.next = null;
        size--;
        return value;
    }

    public int deleteFirstNode() {
        int value = this.head.value;
        this.head = this.head.next;
        size--;
        return value;
    }


    public void printMySinglyLinkedList() {
        System.out.println("Size : " + this.size);
        Node temp = this.head;

        while(temp != null) {
            System.out.print( temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

     class Node {
        private int value;
        private Node next;

        public Node(int value, Node prev) {
            this.value = value;
            this.next = prev.next;
            prev.next = this;
        }

        public Node() {
            this.next = null;
        }

        public Node(int value) {
            this.value = value;
        }

    }

}

class TestMySLL {
    public static void main(String[] args) throws Exception {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList();
        mySinglyLinkedList.printMySinglyLinkedList();

        mySinglyLinkedList.insertAtLast(4);
        mySinglyLinkedList.insertAtLast(0);
        mySinglyLinkedList.insertAtLast(0);
        mySinglyLinkedList.insertAtLast(7);
        mySinglyLinkedList.insertAtFirst(1);
        mySinglyLinkedList.printMySinglyLinkedList();
        mySinglyLinkedList.insertAt(1,2);
        mySinglyLinkedList.printMySinglyLinkedList();
        System.out.println(mySinglyLinkedList.getValueAt(3));
        System.out.println(mySinglyLinkedList.deleteNodeAtIndex(2));
        mySinglyLinkedList.printMySinglyLinkedList();

        System.out.println(mySinglyLinkedList.deleteFirstNode());
        mySinglyLinkedList.printMySinglyLinkedList();

        System.out.println(mySinglyLinkedList.deleteLastNode());
        mySinglyLinkedList.printMySinglyLinkedList();
    }
}


