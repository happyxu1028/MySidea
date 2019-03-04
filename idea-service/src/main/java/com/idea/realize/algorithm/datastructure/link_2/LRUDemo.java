package com.idea.realize.algorithm.datastructure.link_2;

public class LRUDemo {

}

class Node{

    int data;

    Node next;


    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class NodeChain{

    private Node head;

    private Node tail;

    private int size = 0;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }




    private void addHead(int data) {
        Node node = new Node(data,head);
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }


    private void addTail(int data){
        Node node = new Node(data,null);
        Node temp = tail;
        tail = node;
        if(head == null){
            head = tail;
        }else{
            temp.next = node;
        }
        size++;

    }

    private void deleteTail() {
        for(Node node = head; node != null; node = node.next){
            if(node == tail){
                tail = head = null;
                size--;
                break;
            }else if(node.next == tail){
                node.next = null;
                tail = node;
                size--;
                break;
            }
        }

    }

    private void deleteSpec(int data) {
        Node prev = null;
        for(Node node = head; node != null; node = node.next){

            if(node.data == data){
                if(node == head){
                    head = node.next;
                    node.next = null;
                }else{
                    prev.next = prev.next.next;
                    node.next = null;
                }
            }
            prev = node;
        }
        size--;
    }


    public static void main(String[] args) {
        NodeChain nodeChain = new NodeChain();
        nodeChain.addHead(1);
        nodeChain.addHead(2);
        nodeChain.addHead(3);
        nodeChain.addHead(4);
        nodeChain.addHead(5);

        System.out.println("初始化容量:"+nodeChain.size);

        nodeChain.visit(3);
        nodeChain.visit(6);
        nodeChain.visit(3);
        nodeChain.visit(2);
        nodeChain.visit(1);



//        Node node1 = new Node(1,null);
//        Node node2 = node1;
//        node1 = new Node(2,null);
//        System.out.println(node2.data);
    }

    private void visit(int data) {
        Boolean exist = false;

        //1.查询是否存在
        for(Node node = head; node != null; node = node.next){
            if(data == node.data){
                exist = true;
                break;
            }
        }

        //2.若存在删除原有的,头部添加
        if(exist){
            deleteSpec(data);
            addHead(data);
            return;
        }

        //3.若不存在,判断size
        //4.size < 5, 添加
        if (size < 5){
            addHead(data);
        }else{
        //5. size == 5 先删除尾部,再头部添加
            deleteTail();
            addHead(data);
        }


    }


}
