package com.idea.realize.algorithm.linked;


/**
 * @author liguoping
 * @version 1.0
 * @description 基于单向链表实现LRU算法
 * @time 2018/11/1 14:10
 */
public class LinkedLRU {

    Node<Integer> node = new Node<Integer>();

    int capacity = 10;

    public static void main(String[] args) {
        LinkedLRU linkedLRU = new LinkedLRU();
        linkedLRU.init();
        linkedLRU.test();
    }

    public  void init() {

        node.addFirst(1);
        node.addFirst(2);
        node.addFirst(3);
        node.addFirst(4);
        node.addFirst(5);
    }


    public  void test() {
        System.out.println("初始化容量:" + node.length());

        visit(4,node);

        visit(6,node);
        visit(7,node);
        visit(8,node);
        visit(9,node);
        visit(10,node);
        visit(11,node);
        visit(5,node);

    }

    public void visit(int i, Node node) {

        print(node);

        System.out.println("数据前......"+i);
        boolean exist = false;

        for (Node<Integer> first = node.first; first != null; first = first.next) {  // 1. 访问存在的数据,删除原有位置.添加到头部
            if (first.data == i) {
                node.remove(i);
                node.addFirst(i);
                exist = true;
            }
        }

         // 2. 访问不存在数据
        if(!exist){
            if(node.length()<capacity){   // 2.1 不超过容量,插入头部
                node.addFirst(i);
            }else{                        // 2.2 不超过容量,插入头部
                node.remove();
                node.addFirst(i);
            }
        }


        print(node);

        System.out.println("++++++++++++执行完++++++++++++");


    }

    private void print(Node node) {
        for (Node<Integer> temp = node.first; temp != null; temp = temp.next) {
            System.out.print(temp.data+": ");
        }
        System.out.println("    ");
    }


    class Node<E> {
        private Node first; // 头部元素
        private Node tail; // 尾部元素
        private E data; // 存放的数据
        private Node next;  // 下一个指针
        private int size;  // 总数量

        public Node() {

        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void add(E e) {
            linkedLast(e);
        }

        public void addFirst(E e) {
            linkedFirst(e);
        }

        /**
         * 头部插入
         */
        private void linkedFirst(E e) {
            Node f = first;
            Node newNode = new Node(e, f);
            first = newNode;
            if (f == null) {
                tail = first;
            }
            size++;
        }

        /**
         * 尾部插入
         */
        private void linkedLast(E e) {
            Node t = tail;
            Node newNode = new Node(e,null);
            tail = newNode;
            if (t == null) {
                first = tail;
            }else{
                t.next = tail;
            }
            size++;
        }

        private int length() {
            return size;
        }

        private void remove(E e) {
            Node pre = first;
            for (Node node = first; node != null; node = node.next) {
                if (e.equals(node.data)) {
                    if(node!=first){
                        pre.next = pre.next.next;
                    }else{
                        first = first.next;
                    }
                    size--;
                }
                pre = node;
            }
        }

        public void remove(){
            for (Node node = first; node != null; node = node.next) {
                if(node == tail){
                    first = tail = null;
                } else if(node.next == tail) {
                    node.next = null;
                    tail = node;

                }
                size--;
            }
        }
    }
}
