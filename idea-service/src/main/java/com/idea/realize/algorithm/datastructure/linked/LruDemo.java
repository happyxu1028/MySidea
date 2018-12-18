package com.idea.realize.algorithm.datastructure.linked;

public class LruDemo {


    public static void main(String[] args) {
        NodeChain nodeChain = new NodeChain();
        nodeChain.addFirst("1");
        nodeChain.addFirst("2");
        nodeChain.addFirst("3");
        nodeChain.addFirst("4");
        nodeChain.addFirst("5");

        System.out.println("初始化容量:"+nodeChain.size);

        nodeChain.visit("3");
        nodeChain.visit("6");
        nodeChain.visit("3");
        nodeChain.visit("2");
        nodeChain.visit("1");
    }


}
