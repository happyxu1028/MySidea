package com.idea.realize.javacore36.nio;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author happyxu
 * @Description: TODO
 * @Title: SelectorDemo
 * @ProjectName sidea
 * @date 2018/10/79:44 PM
 */
public class SelectorDemo {

    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open();

            socketChannel.configureBlocking(false);
            //一个selector可以接受注册多个channel
            SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_CONNECT);
            while (true) {

                //返回所有注册的已就绪的通道数量
                int readySelectChannel = selector.select();
                if (readySelectChannel == 0) {
                    continue;
                }

                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()) {


                    SelectionKey key = iterator.next();

                    if (key.isAcceptable()) {

                    }

                    if (key.isConnectable()) {

                    }

                    if (key.isReadable()) {

                    }

                    if (key.isWritable()) {

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
