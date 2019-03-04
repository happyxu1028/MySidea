package com.idea.realize.algorithm.datastructure.queue2;

public class AroundQueue {

    private int size;

    private Object[] items;

    private int headCount;

    private int tailCount;

    public AroundQueue(int size) {
        this.size = size;
        this.items = new Object[size];
    }

    public boolean push(Object obj){
        if(((tailCount+1) % size) == headCount){
            return false;
        }
        items[tailCount++] = obj;
        return true;
    }

    public Object take(){
        if(headCount == tailCount){
            return null;
        }

        Object value = items[headCount];
        items[headCount++] = null;
        return value;

    }

    public static void main(String[] args) {
        AroundQueue aroundQueue = new AroundQueue(3);
        aroundQueue.push(1);
        aroundQueue.push(2);
        aroundQueue.push(3);
        aroundQueue.push(4);
        aroundQueue.take();
        aroundQueue.take();
        aroundQueue.push(5);
    }
}
