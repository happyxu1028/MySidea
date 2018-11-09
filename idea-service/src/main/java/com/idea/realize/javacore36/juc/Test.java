package com.idea.realize.javacore36.juc;

import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws Exception {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<?> future = executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "hello";
            }
        });


//        while (future.isDone()){
            System.out.println(future.get());
//        }


//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//
//
//        Object o = future.get();
    }
}
