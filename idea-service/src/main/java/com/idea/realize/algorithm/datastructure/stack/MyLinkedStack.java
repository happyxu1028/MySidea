package com.idea.realize.algorithm.datastructure.stack;

public class MyLinkedStack {


    public static void main(String[] args) {
        Node node = new Node();
        node.push(1);
        node.push(2);
        node.push(3);
        Object pop = node.pop();
        Object pop2 = node.pop();
        Object pop3 = node.pop();
        Object pop4 = node.pop();
        node.push(4);
        System.out.println("over");
    }

}

class Node{
    Node head;
    Object data;
    Node next;

    public Node(){}

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public boolean push(Object obj){
        Node temp = head;
        Node node = new Node(obj,temp);
        head = node;
        return true;
    }

    public Object pop(){
        Node temp = head;
        if(temp == null){
            return null;
        }
        if(temp.next == null){
            head = null;
        }else{
            head = temp.next;
        }
        return temp.data;
    }


}