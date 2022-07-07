package com.ravi.learn.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBinarySearchTree {
    private BinarySearchNode root;

    public MyBinarySearchTree(int rootValue) {
        this.root = new BinarySearchNode(rootValue);
        this.root.parent = null;
    }

    public void insert(int data) throws Exception {
        BinarySearchNode tempNode = root;
        if (tempNode == null) {
            this.root = new BinarySearchNode(data);
        } else insert(data, tempNode);
    }

    private void insert(int data, BinarySearchNode node) throws Exception{
        if (node.data < data) {
            if (node.rightChild == null) {
                node.rightChild = new BinarySearchNode(data);
                node.rightChild.parent = node;
            } else {
                insert(data, node.rightChild);
            }
        } else if (node.data > data) {
            if (node.leftChild == null) {
                node.leftChild = new BinarySearchNode(data);
                node.leftChild.parent = node;
            } else {
                insert(data, node.leftChild);
            }
        } else {
            throw new Exception("Node already exists");
        }
    }

    public BinarySearchNode find(int data) throws Exception {
        BinarySearchNode temp = root;
        return find(data, temp);
    }

    private BinarySearchNode find(int data, BinarySearchNode node) throws Exception {

        if (node == null) {
            throw new Exception("Element doesn't exist");
        }

        if (node.data == data) return node;
        else if (node.data < data) return find(data, node.rightChild);
        else return find(data, node.leftChild);

    }

    public void traverse(BinarySearchTreeTraversal traversalOrder) {
        BinarySearchNode tempNode = this.root;
        System.out.println("\n" + traversalOrder + " :");
        if (traversalOrder.equals(BinarySearchTreeTraversal.PRE_ORDER)) {
            preOrderTraversal(tempNode);
        } else if (traversalOrder.equals(BinarySearchTreeTraversal.POST_ORDER)) {
            postOrderTraversal(tempNode);
        } else if (traversalOrder.equals(BinarySearchTreeTraversal.IN_ORDER)) {
            inOrderTraversal(tempNode);
        } else {
            levelOrderTraversal(tempNode);
        }
    }

    private void preOrderTraversal(BinarySearchNode node) {
        if ( node == null ) return;
        node.visit();
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    private void postOrderTraversal(BinarySearchNode node) {
        if(node == null) return;
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        node.visit();
    }
    private void inOrderTraversal(BinarySearchNode node) {
        if(node == null) return;
        inOrderTraversal(node.leftChild);
        node.visit();
        inOrderTraversal(node.rightChild);
    }

    public void inOrderTraversal2(){
        BinarySearchNode node = this.root;
        System.out.println("In-Order Traversal 2");
        while (node!=null) {
            node.visit();
            node = inOrderSuccessor(node);
        }
    }

    public int inOrderSuccessor(int data) throws Exception{
        BinarySearchNode node = find(data);
        BinarySearchNode inOrderSuccessorNode = inOrderSuccessor(node);
        return inOrderSuccessorNode.data;
    }

    private BinarySearchNode inOrderSuccessor(BinarySearchNode node) {
        if (node.rightChild != null) {
            node = node.rightChild;
            while (node.leftChild != null) {
                node = node.leftChild;
            }
            return node;
        }
        BinarySearchNode parent = node.parent;
        while(parent != null && parent.rightChild == node) {
            node = parent;
            parent = node.parent;
        }
        return parent;
    }

    public void delete(int data) throws Exception{
        BinarySearchNode node = find(data);
        if (node == null) return;
        BinarySearchNode parent = node.parent;


        //case-I if both left and right child are null that is a leaf node
        if (node.leftChild == null && node.rightChild == null) {
            if (parent == null) {
                this.root = null;
                return;
            }
            if (parent.leftChild == node) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return;
        }

        //Case-II If one of them is null
        if (node.leftChild == null || node.rightChild == null ){
            if (node.leftChild != null) {
                if (parent == null) {
                    this.root = node.leftChild;
                    return;
                }
                if (parent.leftChild == node) {
                    parent.leftChild = node.leftChild;
                } else parent.rightChild = node.leftChild;
            } else {
                if(parent == null) {
                    this.root = node.rightChild;
                    return;
                }
                if (parent.leftChild == node) {
                    parent.leftChild = node.rightChild;
                } else parent.rightChild = node.rightChild;
            }
        }

        //case III : If the node to be deleted has both left & right child
        //Get in-order successor node & point the parent to the in-order successor
        //point the in-order successor current node (to be deleted)
        if (node.leftChild != null && node.rightChild != null) {
            BinarySearchNode inOrderSuccessor = inOrderSuccessor(node);
            if (inOrderSuccessor.parent.leftChild == inOrderSuccessor) {
                inOrderSuccessor.parent.leftChild = null;
            } else inOrderSuccessor.parent.rightChild = null;
            inOrderSuccessor.leftChild = node.leftChild;
            inOrderSuccessor.rightChild = node.rightChild;
            //for root node
            if (parent == null) {
                this.root = inOrderSuccessor;
                return;
            }
            if (parent.leftChild == node) parent.leftChild = inOrderSuccessor;
            else parent.rightChild = inOrderSuccessor;
        }

    }

    //
    private void levelOrderTraversal(BinarySearchNode node) {
        // Nodes in a level
        Map<Integer, List<BinarySearchNode>> nodesAtALevel = new HashMap<>();
        List<BinarySearchNode> level0Root = new ArrayList<>();
        level0Root.add(node);
        if (node != null) {
            nodesAtALevel.put(0, level0Root);
            node.visit();
        }

        int i = 0;

        while (true) {
            i++ ;
            List<BinarySearchNode> ithList = new ArrayList<>();
            List<BinarySearchNode> iMinus1thList = nodesAtALevel.get(i-1);
            System.out.println();
            for (BinarySearchNode previousLevelNode : iMinus1thList) {
                if (previousLevelNode.leftChild != null) {
                    ithList.add(previousLevelNode.leftChild);
                    previousLevelNode.leftChild.visit();
                }

                if (previousLevelNode.rightChild != null) {
                    ithList.add(previousLevelNode.rightChild);
                    previousLevelNode.rightChild.visit();
                }
            }
            if (ithList.size() == 0) break;
            nodesAtALevel.put(i, ithList);
        }


    }



    enum BinarySearchTreeTraversal {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER,
        LEVEL_ORDER;
    }


    class BinarySearchNode {
        private int data;
        private BinarySearchNode leftChild;
        private BinarySearchNode rightChild;
        private BinarySearchNode parent;

        public BinarySearchNode(int data) {
            this.data = data;
        }

        public void visit() {
            System.out.print(this.data + " ");
        }

    }

    static class MyBinarySearchTreeTest{
        public static void main(String[] ar) throws Exception{
            MyBinarySearchTree mbst = new MyBinarySearchTree(35);
            mbst.insert(20);
            mbst.insert(16);
            mbst.insert(29);
            mbst.insert(24);
            mbst.insert(27);
            mbst.insert(33);
            mbst.insert(45);
            mbst.insert(42);
            System.out.println(mbst.find(45).leftChild.data);
            mbst.traverse(BinarySearchTreeTraversal.IN_ORDER);
            mbst.traverse(BinarySearchTreeTraversal.PRE_ORDER);
            mbst.traverse(BinarySearchTreeTraversal.POST_ORDER);
            mbst.traverse(BinarySearchTreeTraversal.LEVEL_ORDER);
            System.out.println();
            System.out.println(mbst.inOrderSuccessor(42));
            System.out.println();
            mbst.inOrderTraversal2();
            mbst.delete(29);
            mbst.traverse(BinarySearchTreeTraversal.IN_ORDER);
        }
    }

}
