package com.idea.realize.algorithm.datastructure.stack;

public class MyArrayStack {

    int count;

//    Object head;

    int capcity;

    Object[] items;


    public MyArrayStack(int capcity) {
        this.capcity = capcity;
        items = new Object[capcity];
        count = 0;
    }

    public boolean push(Object obj){
        if(capcity == count){
            return false;
        }
        items[count++] = obj;
        return true;
    }

    public Object pop(){
        if(count == 0 || null == items){
            return null;
        }
        int pos = count-1;
        Object obj = items[pos];
        items[pos] = null;
        count--;
        return obj;
    }

    public void print(){
        for(int i = 0; i < count; i++){
            System.out.println(items[i].toString());
        }
    }

    public static void main(String[] args) {
        MyArrayStack myArrayStack = new MyArrayStack(4);
        myArrayStack.push(1);
        myArrayStack.push(3);
        myArrayStack.push(4);
        myArrayStack.push(1);
        myArrayStack.push(4);
        myArrayStack.push(7);
        myArrayStack.pop();
        myArrayStack.pop();
        myArrayStack.pop();
        myArrayStack.push(10);
        myArrayStack.print();
    }
}
