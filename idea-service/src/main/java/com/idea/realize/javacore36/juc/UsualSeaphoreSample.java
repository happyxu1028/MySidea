package com.idea.realize.javacore36.juc;

import java.util.concurrent.Semaphore;

public class UsualSeaphoreSample {

    public static void main(String[] args) {
        System.out.println("Action...Go...");
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            SemaphoreWorker semaphoreWorker = new SemaphoreWorker(semaphore);
            new Thread(semaphoreWorker).start();
        }
    }
}

class SemaphoreWorker implements Runnable {

    private String name;

    private Semaphore semaphore;


    public SemaphoreWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            log("is waiting for a permit");
            semaphore.acquire();
            log("acquire a permit!");
            log("execute!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log("released a permit!");
            semaphore.release();
        }
    }

    private void log(String message) {
        if (null == name) {
            name = Thread.currentThread().getName();
        }
        System.out.println(name + " : " + message);
    }
}
