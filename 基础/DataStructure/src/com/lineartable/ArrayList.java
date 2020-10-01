package com.lineartable;

import java.util.Arrays;

/**
 * 顺序表
 * 底层采用数组，但长度可以动态变化
 */
public class ArrayList implements List {

    private Object[] elementData;    //底层为数组，长度未定

    private int size;    //元素的个数

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                builder.append(elementData[i]).append(",");
            } else {
                builder.append(elementData[i]);
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public ArrayList() {
        //没有指定长度，默认长度是4;
        this(4);
        //没有指定长度，长度是0
        //elementData=new Object[]{};
    }

    public ArrayList(int initialCapacity) {
        //给数组分配指定数量的空间
        elementData = new Object[initialCapacity];
        //指定顺序表的元素个数,默认是0
        //size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i >= size) {
            throw new RuntimeException("数组索引越界异常：" + i); //可使用自定义异常
        }
        return elementData[i];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }

    @Override
    public int indexOf(Object e) {
        if (e == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (e.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public void add(int i, Object e) {
        rangeCheck(i);
        //数组满了，就扩容
        if (size == elementData.length) {
            grow();
        }
        //后移i及其后面的位置，从最后一个开始
        for (int j = size; j > i; j--) {
            elementData[j] = elementData[j - 1];
        }
        //给数组第i个位置赋值
        elementData[i] = e;
        //元素个数加1
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
        /**
         //数组满了，就扩容
         if (size == elementData.length) {
         grow();
         }
         //给数组赋值
         //elementData[size]=e;
         //元素个数加1
         //size++;
         elementData[size++] = e;
         */
    }

    private void grow() {
        //新创建一个新的数组，长度是旧数组的2倍,源码是增长50%
        Object[] newArr = new Object[elementData.length * 2];
        //将旧数组的数据拷贝到新数组
        for (int i = 0; i < size; i++) {
            newArr[i] = elementData[i];
        }
        //让elementData指向新数组
        elementData = newArr;
        //等价于elementData = Arrays.copyOf(elementData,elementData.length*2);
    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        int index = 0;
        for (; index < size; index++) {
            if (elementData[index].equals(obj)) {
                this.add(index, e);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        int index = 0;
        for (; index < size; index++) {
            if (elementData[index].equals(obj)) {
                this.add(index + 1, e);
                return true;
            }
        }
        return false;
    }

    @Override
    public Object remove(int i) {
        rangeCheck(i);
        Object oldElement = elementData[i];
        fastRemove(i);
        return oldElement;
    }

    @Override
    public boolean remove(Object e) {
        if (e == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (e.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void fastRemove(int index) {
        Object[] newArr = new Object[size - 1];
        int newI = 0;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                continue;
            }
            newArr[newI] = elementData[i];
            newI++;
        }
        elementData = newArr;
        size--;
    }

    @Override
    public Object replace(int i, Object e) {
        rangeCheck(i);
        elementData[i] = e;
        return elementData;
    }
}