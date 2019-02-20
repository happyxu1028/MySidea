package com.idea.realize.study.shiro;

public class ThreadLocalTest2 extends Thread {

    public static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<String>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开启");
        inheritableThreadLocal.set("主线程赋值");

        new MyThead().start();

        System.out.println("主线程休眠3秒");
        Thread.sleep(3000);
        System.out.println("主线程休眠结束");
    }


    static class MyThead extends Thread {
        public void run() {
            System.out.println("子线程开启");
            System.out.println("子线程获取本地变量: " + inheritableThreadLocal.get());
            System.out.println("子线程结束");
        }
    }


}
