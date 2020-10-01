package com.tree;

/**
 * 链式二叉树结点
 */
public class Node {

    private Object value;  //值
    private Node leftChild; //左子树的引用
    private Node rightChild; //右子树的引用

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node leftChild, Node rightChild) {
        super();
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node lNode) {
        this.leftChild = lNode;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rNode) {
        this.rightChild = rNode;
    }

}
