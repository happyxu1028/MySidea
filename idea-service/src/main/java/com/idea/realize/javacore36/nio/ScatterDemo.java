package com.idea.realize.javacore36.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

/**
 * @author happyxu
 * @Description: TODO
 * @Title: ScatterDemo
 * @ProjectName sidea
 * @date 2018/10/25:46 PM
 */
public class ScatterDemo {


    public static void main(String[] args) {


        try {

            RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/apple/Documents/TEST/abc.txt","rw");
            FileChannel fileChanel = randomAccessFile.getChannel();

            ByteBuffer headerBuf = ByteBuffer.allocate(2);
            ByteBuffer bodyBuf = ByteBuffer.allocate(2);

            ByteBuffer[] array = new ByteBuffer[]{headerBuf,bodyBuf};

            long readResult = fileChanel.read(array);

            while(readResult != -1){
                headerBuf.flip();
                bodyBuf.flip();


//                boolean headOver = false;
                while(headerBuf.hasRemaining()){
                    byte b = headerBuf.get();
                    System.out.println((char)b);
                }

                while(bodyBuf.hasRemaining()){
                    System.out.println((char) bodyBuf.get());
                }

                headerBuf.clear();
                bodyBuf.clear();
                readResult = fileChanel.read(array);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
