package com.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBinaryTree implements BinaryTree {

    private Node root;  //根结点

    public LinkedBinaryTree() {
    }

    public LinkedBinaryTree(Node root) {
        super();
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public int size() {
        System.out.print("二叉树的结点数：");
        return this.size(root);
    }

    private int size(Node root) {
        if (root != null) {
            //左子树结点数
            int leftSize = this.size(root.getLeftChild());
            //右子树结点数
            int rightSize = this.size(root.getRightChild());
            return leftSize + rightSize + 1;
        }
        return 0;
    }

    @Override
    public int getHeight() {
        System.out.print("二叉树的高度：");
        return this.getHeight(root);
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            //左子树的高度
            int leftHeight = this.getHeight(root.getLeftChild());
            //右子树的高度
            int rightHeight = this.getHeight(root.getRightChild());
            //返回结点的高度
            return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
        }
    }

    @Override
    public Node findKey(Object value) {
        return this.findKey(value, root);
    }

    private Node findKey(Object value, Node root) {
        if (root == null)
            return null;
        else if (root.getValue().equals(value))
            //是否为根节点
            return root;
        else {
            Node leftChild = this.findKey(value, root.getLeftChild());
            Node rightChild = this.findKey(value, root.getRightChild());
            if (leftChild != null && leftChild.getValue().equals(value))
                //是否为左子树
                return leftChild;
            else if (rightChild != null && rightChild.getValue().equals(value))
                //是否为右子树
                return rightChild;
            else
                return null;
        }
    }

    @Override
    public void preOrderTraverse() {
        /**
         if (this.root != null) {
         //根结点的值
         System.out.print(root.getValue() + " ");
         //对左子树进行先序遍历
         BinaryTree leftTree = new LinkedBinaryTree(root.getLeftChild());
         leftTree.preOrderTraverse();
         //对右子树进行先序遍历
         BinaryTree rightTree = new LinkedBinaryTree(root.getRightChild());
         rightTree.preOrderTraverse();
         }
         */
        System.out.println("前序遍历--递归");
        this.preOrderTraverse(this.root);
        System.out.println();
    }

    private void preOrderTraverse(Node root) {
        if (root != null) {
            //输出结点的值
            System.out.print(root.getValue() + " ");
            //遍历左子树
            this.preOrderTraverse(root.getLeftChild());
            //遍历右子树
            this.preOrderTraverse(root.getRightChild());
        }
    }

    @Override
    public void inOrderTraverse() {
        /**
         if (this.root != null) {
         //对左子树进行中序遍历
         BinaryTree leftTree = new LinkedBinaryTree(root.getLeftChild());
         leftTree.inOrderTraverse();
         //根结点的值
         System.out.print(root.getValue() + " ");
         //对右子树进行中序遍历
         BinaryTree rightTree = new LinkedBinaryTree(root.getRightChild());
         rightTree.inOrderTraverse();
         }
         System.out.println();
         */
        System.out.println("中序遍历--递归");
        this.inOrderTraverse(this.root);
        System.out.println();
    }

    private void inOrderTraverse(Node root) {
        if (root != null) {
            //遍历左子树
            this.inOrderTraverse(root.getLeftChild());
            //输出结点的值
            System.out.print(root.getValue() + " ");
            //遍历右子树
            this.inOrderTraverse(root.getRightChild());
        }
    }

    @Override
    public void postOrderTraverse() {
        /**
         if (this.root != null) {
         //对左子树进行后序遍历
         BinaryTree leftTree = new LinkedBinaryTree(root.getLeftChild());
         leftTree.postOrderTraverse();
         //对右子树进行后序遍历
         BinaryTree rightTree = new LinkedBinaryTree(root.getRightChild());
         rightTree.postOrderTraverse();
         //根结点的值
         System.out.print(root.getValue() + " ");
         }
         */
        System.out.println("后序遍历--递归");
        this.postOrderTraverse(this.root);
        System.out.println();
    }

    private void postOrderTraverse(Node root) {
        if (root != null) {
            //对左子树进行后序遍历
            this.postOrderTraverse(root.getLeftChild());
            //对右子树进行后序遍历
            this.postOrderTraverse(root.getRightChild());
            //根结点的值
            System.out.print(root.getValue() + " ");
        }
    }

    @Override
    public void preOrderByStack() {
        if (root == null)
            return;
        System.out.println("前序非递归遍历");
        Deque<Node> deque = new LinkedList<>();
        Node current = root;
        while (current != null || !deque.isEmpty()) {
            while (current != null) {
                deque.push(current);
                System.out.print(current.getValue() + " ");
                current = current.getLeftChild();
            }
            if (!deque.isEmpty()) {
                current = deque.pop();
                current = current.getRightChild();
            }
        }
        System.out.println();
    }

    @Override
    public void inOrderByStack() {
        if (root == null)
            return;
        System.out.println("中序非递归遍历");
        Deque<Node> deque = new LinkedList<>();
        Node current = root;
        while (current != null || !deque.isEmpty()) {
            while (current != null) {
                deque.push(current);    //入栈
                current = current.getLeftChild();
            }
            if (!deque.isEmpty()) {
                current = deque.pop();   //出栈
                System.out.print(current.getValue() + " ");
                current = current.getRightChild();
            }
        }
        System.out.println();
    }

    /**
     * flag
     * 用来记录最新出栈的节点，如果当前节点的右孩子与flag相同，说明当前节点右子树已完成遍历
     */
    @Override
    public void postOrderByStack() {
        if (root == null)
            return;
        System.out.println("后序非递归遍历");
        Deque<Node> deque = new LinkedList<>();
        Node current = root;
        Node flag = null;
        while (current != null) {
            //根结点及其根结点的左子树(最左侧的所有结点+根节点)...全部入栈
            deque.push(current);
            current = current.getLeftChild();
        }
        while (!deque.isEmpty()) {
            current = deque.pop();  //出栈
            if (current.getRightChild() == null || current.getRightChild() == flag) {
                System.out.print(current.getValue() + " "); //输出当前值
                flag = current;
            } else {
                deque.push(current);
                current = current.getRightChild();
                while (current != null) {
                    deque.push(current);
                    current = current.getLeftChild();
                }
            }
        }
        System.out.println();
    }

    @Override
    public void levelOrderByQueue() {
        if (root == null)
            return;
        System.out.print("按照层次进行遍历");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);    //root入队
        while (queue.size() != 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();   //出队
                if (temp != null) {
                    System.out.print(temp.getValue() + " ");
                    if (temp.getLeftChild() != null)
                        queue.add(temp.getLeftChild());
                    if (temp.getRightChild() != null)
                        queue.add(temp.getRightChild());
                }
            }
        }
        System.out.println();
    }
}
