package com.idea.realize.algorithm.datastructure.linked.exec;

public class LinkCircleCheckDemo {


    public static void main(String[] args) {
        Node node8 = new Node(8,null);
        Node node7 = new Node(7,node8);
        Node node6 = new Node(6,node7);
        Node node5 = new Node(5,node6);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node head = new Node(1,node2);
        node8.next = node4;


        Node circle = findCircle(head);


        System.out.println(circle.data);
    }

    public static Node findCircle(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node fast = head;
        Node slow = head;

        Node meet = null;
        while(fast != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                meet = fast;
                break;
            }
        }

        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return  fast;

    }

    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


}



