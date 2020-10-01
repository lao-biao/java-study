package com.lineartable;

public interface Stack {
    //返回堆栈的大小
    public int getSize();

    //判断栈顶是否为空
    public boolean isEmpty();

    //数据元素e入栈
    public void push(Object e);

    //栈顶元素出栈
    public Object pop();

    //取栈顶元素
    public Object peek();
}
