package com.idea.realize.algorithm.datastructure.stack2;

public class LinkedStack {


    private Node tail;

    private Node head;

    public class Node{

        public Object data;

        public Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    public void addTail(int data){
       Node node = new Node(data,null);
       Node temp = tail;
       tail = node;
       if(temp == null){
           head = tail;
       }else{
           temp.next = node;
       }
    }

    public Object takeTail(){
        for(Node node  = head; node!= null; node = node.next){
            if(node == tail){
                head = tail = null;
                return node;
            }
            if(node.next == tail){
                Node temp = tail;
                node.next = null;
                tail = node;
                return temp;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.addTail(1);
        linkedStack.addTail(2);
        linkedStack.addTail(3);
        linkedStack.addTail(4);
    }
}
