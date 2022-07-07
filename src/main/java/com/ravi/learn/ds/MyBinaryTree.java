package com.ravi.learn.ds;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MyBinaryTree<E> {
    private BinaryNode<E> root;
    private BinaryTreeTraversalOrder preOrder = BinaryTreeTraversalOrder.PRE_ORDER;
    private BinaryTreeTraversalOrder inOrder = BinaryTreeTraversalOrder.IN_ORDER;
    private BinaryTreeTraversalOrder postOrder = BinaryTreeTraversalOrder.POST_ORDER;


    public MyBinaryTree(Scanner input) {
        this.root = buildTree(input);
    }

    private BinaryNode<E> buildTree(Scanner input){
        while(input.hasNext()) {
            E data = (E) input.next();
            if ("@".equals(data)) return null;
            else {
                BinaryNode node = new BinaryNode(data);
                node.leftChild = buildTree(input);
                node.rightChild = buildTree(input);
                return node;
            }
        }
        return null;
    }

    public void traverse(BinaryTreeTraversalOrder traversalOrder) {
        BinaryNode tempNode = this.root;
        System.out.println("\n" + traversalOrder);
        if(traversalOrder.equals(preOrder)) preOrderTraversal(tempNode);
         else if (traversalOrder.equals(postOrder)) postOrderTraversal(tempNode);
         else if (traversalOrder.equals(inOrder)) inOrderTraversal(tempNode);
    }

    private void preOrderTraversal(BinaryNode node) {
        if (node == null ) return;
        node.visit();
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }
    private void postOrderTraversal(BinaryNode node) {
        if (node == null ) return;
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        node.visit();
    }

    private void inOrderTraversal(BinaryNode node) {
        if (node == null ) return;
        inOrderTraversal(node.leftChild);
        node.visit();
        inOrderTraversal(node.rightChild);
    }



    class BinaryNode<E> {
        private E data;
        private BinaryNode<E> leftChild;
        private BinaryNode<E> rightChild;

        BinaryNode(E data){
            this.data = data;
        }

        public void visit(){
            System.out.print(this.data + "  ");
        }

    }

    enum BinaryTreeTraversalOrder {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER;

    }

    static class MyBinaryTreeTest{
        public static void main(String[] args) throws IOException {
            File file = new File("./src/main/resources/binaryTree.txt");
            //Scanner will take input before the white space :-) A B C will be 3 inputs A, B, C
            Scanner input = new Scanner(new FileReader(file));
            MyBinaryTree<String> myBinaryTree = new MyBinaryTree<>(input);
            BinaryTreeTraversalOrder preOrderTraversal = BinaryTreeTraversalOrder.PRE_ORDER;
            BinaryTreeTraversalOrder postOrderTraversal = BinaryTreeTraversalOrder.POST_ORDER;
            BinaryTreeTraversalOrder inOrderTraversal = BinaryTreeTraversalOrder.IN_ORDER;
            myBinaryTree.traverse(preOrderTraversal);
            myBinaryTree.traverse(postOrderTraversal);
            myBinaryTree.traverse(inOrderTraversal);
        }
    }


}
