package com.lineartable;

/**
 * 模拟实现单链表
 */
public class SingleLinkedList implements List {

    private Node head = new Node();     //头结点，不存储数据，只为操作链表

    private int size;      //结点数，不包括头结点

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        Node p = head.getNext();
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                builder.append(p.getData()).append(",");
            } else {
                builder.append(p.getData());
            }
            //移动指针
            p = p.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        Node p = head;
        for (int j = 0; j <= i; j++) {
            p = p.getNext();
        }
        return p.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        return indexOf(e) > 0;
    }

    @Override
    public int indexOf(Object e) {
        Node p = head;
        int index = 0;
        if (e == null) {
            for (; index < size; index++) {
                p = p.getNext();
                if (p.getData() == null) {
                    return index;
                }
            }
        } else {
            for (; index < size; index++) {
                p = p.getNext();
                if (p.getData().equals(e)) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public void add(int i, Object e) {
        //检查索引是否越界
        rangeCheck(i);
        //找到前一个结点，从头结点开始
        Node p = head;
        for (int j = 0; j < i; j++) {
            p = p.getNext();
        }
        //创建新结点
        Node newNode = new Node();
        newNode.setData(e);
        //指明新结点的直接后继
        newNode.setNext(p.getNext());
        //指明新结点的直接前驱
        p.setNext(newNode);
        //元素个数+1
        size++;
    }

    private void rangeCheck(int index) {
        //判断i是否为异常值
        if (index < 0 || index > size) {
            throw new RuntimeException("数组索引越界异常：" + index);
        }
    }

    @Override
    public void add(Object e) {
        this.add(size, e);
    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        Node p = head;
        //先找到前一个结点，在前一个结点后面添加
        for (int i = 0; i < size; i++) {
            if (obj == null) {
                if (p.getNext().getData() == null) {
                    this.add(i, e);
                    return true;
                }
            } else {
                if (p.getNext().getData().equals(obj)) {
                    this.add(i, e);
                    return true;
                }
            }
            p = p.getNext();
        }
        return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        Node p = head;
        for (int i = 0; i < size; i++) {
            p = p.getNext();
            if (obj == null) {
                if (p.getData() == null) {
                    this.add(i + 1, e);
                    return true;
                }
            } else {
                if (p.getData().equals(obj)) {
                    this.add(i + 1, e);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object remove(int i) {
        rangeCheck(i);
        //拿到前一个结点
        Node p = head;
        for (int j = 0; j < i; j++) {
            p = p.getNext();
        }
        //获取该节点
        Node now = p.getNext();
        //删除该结点：前一个结点直接指向该结点的直接后续
        p.setNext(now.getNext());
        //元素数量-1
        size--;
        return now.getData();
    }

    @Override
    public boolean remove(Object e) {
        //拿到前一个结点
        Node p = head;
        for (int i = 0; i < size; i++) {
            if (e == null) {
                if (p.getNext().getData() == null) {
                    //删除操作
                    Node next = p.getNext().getNext();
                    p.setNext(next);
                    //元素数量-1
                    size--;
                    return true;
                }
            } else {
                if (p.getNext().getData().equals(e)) {
                    //删除操作
                    Node next = p.getNext().getNext();
                    p.setNext(next);
                    //元素数量-1
                    size--;
                    return true;
                }
            }
            p = p.getNext();
        }
        return false;
    }

    @Override
    public Object replace(int i, Object e) {
        rangeCheck(i);
        //拿到前一个结点
        Node p = head;
        for (int j = 0; j <= i; j++) {
            p = p.getNext();
        }
        Object oldData = p.getData();
        p.setData(e);
        return oldData;
    }
}
