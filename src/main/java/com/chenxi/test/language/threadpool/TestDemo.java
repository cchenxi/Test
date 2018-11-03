package com.chenxi.test.language.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++) {
//            int index = i;
//            Thread.sleep(100);
//            executorService.submit(() -> {
//                System.out.println(Thread.currentThread().getName() + ":" + index);
//            });
//        }
//        executorService.shutdown();

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 10; i++) {
//            int index = i;
//            executorService.submit(() -> {
//                System.out.println(Thread.currentThread().getName() + ":" + index);
//            });
//        }
//        executorService.shutdown();

//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        for (int i = 0; i < 10; i++) {
//            int index = i;
//            Thread.sleep(100);
//            executorService.submit(() -> {
//                System.out.println(Thread.currentThread().getName() + ":" + index);
//            });
//        }
//        executorService.shutdown();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < 10; i++) {
            int index = i;
            scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println(Thread.currentThread().getName() + ":" + index), 3, 2, TimeUnit.SECONDS);
        }
    }
}
