package com.idea.realize.algorithm.datastructure.queue2;

public class ArrayQueue {


    private int headCount;

    private int tailCount;

    private Object[] items;

    private int size;

    public ArrayQueue(int size) {
        this.size = size;
        this.items = new Object[size];
    }



    public boolean push(Object obj){
        if(tailCount == size){
            if(headCount == 0){
                return false;
            }
            int tempCount = headCount;
            for(int i =0; i < tailCount-headCount; i++){
                items[i] = items[headCount+i];
                items[headCount+i]  = null;
            }
            headCount = 0;
            tailCount = tailCount - tempCount;
        }
        items[tailCount++] = obj;
        return true;
    }

    public Object take(){
        if(tailCount == 0){
            return null;
        }
        return items[headCount++];
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.take();
        arrayQueue.push(4);
    }

}
