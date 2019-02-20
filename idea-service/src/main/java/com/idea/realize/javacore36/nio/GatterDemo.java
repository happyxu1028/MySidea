package com.idea.realize.javacore36.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author happyxu
 * @Description: TODO
 * @Title: GatterDemo
 * @ProjectName sidea
 * @date 2018/10/26:37 PM
 */
public class GatterDemo {


    public static void main(String[] args) {

        try {
            ByteBuffer headerBuf = ByteBuffer.allocate(4);
            ByteBuffer bodyBuf = ByteBuffer.allocate(2);

            headerBuf.put("9".getBytes());
            headerBuf.put("8".getBytes());
            headerBuf.put("7".getBytes());
            headerBuf.put("d".getBytes());

            bodyBuf.put("e".getBytes());


            //往buffer录入完数据后,需要切换buffer的读写模式
            headerBuf.flip();
            bodyBuf.flip();

//            RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/apple/Documents/TEST/abc.txt","rw");

            FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/apple/Documents/TEST/abc.txt"), true);

            FileChannel fileChannel = fileOutputStream.getChannel();
            System.out.println(fileChannel.position());
            long write = fileChannel.write(new ByteBuffer[]{headerBuf, bodyBuf});


            fileChannel.close();
            fileOutputStream.flush();
            fileOutputStream.close();

//            fileChannel.size()
//            System.out.println(fileChannel.position());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
