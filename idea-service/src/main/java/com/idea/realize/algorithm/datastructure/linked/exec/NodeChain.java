package com.idea.realize.algorithm.datastructure.linked.exec;

public class NodeChain {

    /**
     * 链表头指针
     */
    Node head;

    /**
     * 链表尾部指针
     */
    Node tail;

    /**
     * 链表长度
     */
    int size;


    /**
     * 链表节点
     */
    class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    public void moveBefore2Tail() {
        for (Node node = head; node != tail; node.next = node.next.next) {
            //链表元素<=1,不用倒序
            if (head == tail) {
                return;
            }
            Node temp = node.next;

            addHead(temp.data);

        }
    }

    public void addHead(int data) {
        Node temp = head;
        Node node = new Node(data, temp);
        head = node;
        if (temp == null) {
            tail = head;
        }
        size++;
    }


    public void addTail(int data) {
        Node temp = tail;
        Node node = new Node(data, null);
        tail = node;
        if (temp == null) {
            head = tail;
        } else {
            temp.next = tail;
        }
        size++;
    }
}