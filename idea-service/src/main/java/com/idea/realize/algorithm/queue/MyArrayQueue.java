package com.idea.realize.algorithm.queue;

/**
 * 数组实现有界队列
 */
public class MyArrayQueue {

    int capacity;

    Object item[];

    int head;

    int tail;

    public MyArrayQueue(int capacity) {
        this.capacity = capacity;
        item = new Object[capacity];
    }

    public boolean push(Object obj){
        //tail指针已到极限
        if(tail == capacity){
            if(head == 0){
                return false;
            }
            //整体往前移动head个单元
            for(int pos = head; pos < tail; pos++){
                item[pos-head] = item[pos];
            }
            tail = tail-head;
            head = 0;
//            return false;
        }

        item[tail++] = obj;
        return true;
    }

    public Object pop(){
        //判空
        if(head == tail){
            return null;
        }
        Object temp = item[head];
        item[head++] = null;
        return temp;
    }

    public static void main(String[] args) {
        MyArrayQueue myArrayQueue = new MyArrayQueue(2);
        myArrayQueue.push(1);
        myArrayQueue.push(2);
        myArrayQueue.push(3);
        myArrayQueue.pop();
        myArrayQueue.push(4);
        myArrayQueue.pop();
        myArrayQueue.push(5);
        myArrayQueue.pop();
        myArrayQueue.push(6);
        myArrayQueue.push(7);
        myArrayQueue.pop();
    }
}
