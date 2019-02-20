package com.idea.realize.javacore36.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author happyxu
 * @Description: TODO
 * @Title: FileChannelDemo02
 * @ProjectName sidea
 * @date 2018/10/78:43 PM
 */
public class FileChannelDemo02 {


    public static void main(String[] args) {
        transferTo();

    }


    private static void transferTo() {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("/Users/apple/Documents/TEST/fromFile.txt", "r");
            FileChannel fromChannel = fromFile.getChannel();
            RandomAccessFile toFile = new RandomAccessFile("/Users/apple/Documents/TEST/toFile.txt", "rw");
            FileChannel toChannel = toFile.getChannel();
            fromChannel.transferTo(0, fromChannel.size(), toChannel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void transferFrom() {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("/Users/apple/Documents/TEST/fromFile.txt", "r");
            FileChannel fromChannel = fromFile.getChannel();
            RandomAccessFile toFile = new RandomAccessFile("/Users/apple/Documents/TEST/toFile.txt", "rw");
            FileChannel toChannel = toFile.getChannel();
            toChannel.transferFrom(fromChannel, 0, fromChannel.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
