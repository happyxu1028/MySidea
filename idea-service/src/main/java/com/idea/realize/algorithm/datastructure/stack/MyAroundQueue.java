package com.idea.realize.algorithm.datastructure.stack;

/**
 * 数组实现唤醒队列
 */
public class MyAroundQueue {

    int capacity;

    Object items[];

    int head;

    int tail;

    public MyAroundQueue(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
    }

    public boolean push(Object obj){
        //判断队列已满
        int nextPos = (tail+1)%capacity;
        if(nextPos == head){
            return false;
        }
        items[tail] = obj;
        tail = nextPos;
        return true;
    }

    public Object pop(){
        if(head == tail){
            return null;
        }
        Object temp = items[head];
        items[head] = null;
        head++;
        return temp;
    }

    public static void main(String[] args) {
        MyAroundQueue myAroundQueue = new MyAroundQueue(3);
        myAroundQueue.push("1");
        myAroundQueue.push("2");
        myAroundQueue.push("3");
        myAroundQueue.push("4");
        myAroundQueue.pop();
        myAroundQueue.push("5");
        myAroundQueue.pop();
        myAroundQueue.pop();
        myAroundQueue.push("6");
        myAroundQueue.push("7");
        myAroundQueue.push("8");


    }
}
