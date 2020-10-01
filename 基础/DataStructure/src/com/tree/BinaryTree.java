package com.tree;

/**
 * 二叉树操作接口
 */
public interface BinaryTree {

    /**
     * 是否为空树
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * 树结点数量
     *
     * @return
     */
    public int size();

    /**
     * 树的高度
     *
     * @return
     */
    public int getHeight();

    /**
     * 查询指定值的结点
     *
     * @param value
     * @return
     */
    public Node findKey(Object value);

    /**
     * 前序递归遍历
     */
    public void preOrderTraverse();

    /**
     * 中序递归遍历
     */
    public void inOrderTraverse();

    /**
     * 后序递归遍历
     */
    public void postOrderTraverse();

    /**
     * 前序遍历非递归操作
     */
    public void preOrderByStack();

    /**
     * 中序遍历非递归操作
     */
    public void inOrderByStack();

    /**
     * 后序遍历非递归操作
     */
    public void postOrderByStack();

    /**
     * 按照层次遍历二叉树
     */
    public void levelOrderByQueue();

}
