package com.idea.realize.algorithm.datastructure.linked;

public class NodeChain {


    Node head;

    Node tail;

    int size;

    /**
     * 头部插入
     *
     * @param data
     */
    public void addFirst(String data) {
        Node temp = head;
        Node node = new Node(data, temp);
        head = node;
        if (temp == null) {
            tail = head;
        }
        size++;
    }

    /**
     * 尾部插入
     *
     * @param data
     */
    public void addLast(String data) {
        Node temp = tail;
        Node node = new Node(data, null);
        tail = node;
        if (temp == null) {
            head = tail;
        } else {
            temp.next = node;
        }
        size++;
    }

    /**
     * 删除指定节点
     *
     * @param data
     */
    public void remove(String data) {
        Node prev = head;
        for (Node node = head; node != null; node = node.next) {
            if (data.equals(node.data)) {
                if (node == head) {
                    head = head.next;
                } else {
                    prev.next = prev.next.next;
                }
            }
            prev = node;
        }
        size--;
    }

    /**
     * 删除头结点
     */
    public void remove() {
        for (Node node = head; node != null; node = node.next) {
            if (node == tail) {
                head = tail = null;
            } else if (node.next == tail) {
                tail = node;
                node.next = null;
            }
        }
        size--;
    }

    /**
     * 打印节点
     *
     * @param nodeChain
     */
    private void print(NodeChain nodeChain) {
        for (Node temp = nodeChain.head; temp != null; temp = temp.next) {
            System.out.print(temp.data + ": ");
        }
        System.out.println("    ");
    }


    public void visit(String value) {
        System.out.println("即将处理访问的数据>>>>>>> " + value);
        print(this);

        boolean exist = false;

        for (Node node = head; node != null; node = node.next) {
            if (node.data == value) {
                this.remove(value);
                addFirst(value);
                exist = true;
            }
        }

        if (!exist) {
            if (this.size < 5) {
                addFirst(value);
            } else {
                remove();
                addFirst(value);
            }
        }
        System.out.println("已处理访问的数据>>>>>>> " + value);
        print(this);
    }

}
