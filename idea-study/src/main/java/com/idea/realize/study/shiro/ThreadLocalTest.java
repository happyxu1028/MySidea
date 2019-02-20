package com.idea.realize.study.shiro;

public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();

        threadLocal.set("abc");
        threadLocal.set("1");

        System.out.println("dedao: " + threadLocal.get());
    }
}
