package com.idea.realize.algorithm.datastructure.stack2;

public class ArrayStack {


    /**
     * 栈的大小
     */
    private int stackSize;

    /**
     * 栈的容器
     */
    private Object[] items;

    /**
     * 栈中数据大小
     */
    private int count;

    /**
     * 栈定指针
     */
    private Object top;

    public ArrayStack(int stackSize) {
        this.stackSize = stackSize;
        items = new Object[stackSize];
    }


    public void push(Object obj){
        if(null == obj){
            return;
        }

        //两倍扩容
        if(count == stackSize){
            Object[] newItems = new Object[stackSize*2];
            for(int i = 0; i < items.length; i++){
                newItems[i] = items[i];
            }
            items = newItems;
            stackSize = stackSize*2;
        }
        items[count++] = obj;
    }

    public Object take(){
        if(count == 0){
            return null;
        }
        return items[--count];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(2);
        arrayStack.push(1);
        arrayStack.push(2);
        System.out.println(arrayStack.take());
    }
}
