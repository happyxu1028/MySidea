package com.idea.realize.javacore36.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author happyxu
 * @Description: TODO
 * @Title: FileChannelDemo
 * @ProjectName sidea
 * @date 2018/9/289:59 PM
 */
public class FileChannelDemo {

    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/apple/Documents/TEST/abc.txt", "rw");
            FileChannel inChannel = randomAccessFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(2);


            int byteReadResult = inChannel.read(buf);
            while (byteReadResult != -1) {
                System.out.println("Read : " + byteReadResult);
                buf.flip();

                while (buf.hasRemaining()) {
                    System.out.println((char) buf.get());
                }

                buf.clear();
                byteReadResult = inChannel.read(buf);
            }

            randomAccessFile.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFileByChannel(File source, File dest) throws
            IOException {
        try (FileChannel sourceChannel = new FileInputStream(source).getChannel();
             FileChannel targetChannel = new FileOutputStream(dest).getChannel();
        ) {
            for (long count = sourceChannel.size(); count > 0; ) {
                long transferred = sourceChannel.transferTo(sourceChannel.position(), count, targetChannel);
                sourceChannel.position(sourceChannel.position() + transferred);
                count -= transferred;
            }
        }
    }


}
