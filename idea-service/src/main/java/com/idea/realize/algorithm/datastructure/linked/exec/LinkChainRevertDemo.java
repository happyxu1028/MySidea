package com.idea.realize.algorithm.datastructure.linked.exec;

public class LinkChainRevertDemo {


    public static void main(String[] args) {
        NodeChain nodeChain = new NodeChain();
        nodeChain.addTail(1);
        nodeChain.addTail(2);
        nodeChain.addTail(3);
        nodeChain.addTail(4);
        nodeChain.addTail(5);

        nodeChain.head = reverseLinkedList2(nodeChain.head);

        for (NodeChain.Node node = nodeChain.head; node != null; node = node.next) {
            System.out.println(node.data);
        }
    }

    public static NodeChain.Node reverseLinkedList(NodeChain.Node node) {

        if (node == null || node.next == null) {
            return node;
        } else {
            NodeChain.Node headNode = reverseLinkedList(node.next);
            node.next.next = node;
            node.next = null;
            return headNode;
        }

    }

    public static NodeChain.Node reverseLinkedList2(NodeChain.Node node) {
        NodeChain.Node prev = null;
        NodeChain.Node next = null;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }


}



