package com.chenxi.test.language.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public static void test() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 50, 1,
                TimeUnit.MINUTES, new LinkedBlockingQueue<>(1000));

        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(() -> {
                queue.offer(System.currentTimeMillis() + "");
            });
        }

        while (true) {
            threadPoolExecutor.execute(() -> {
                String a = queue.poll();
                if (a == null) {
                    threadPoolExecutor.shutdownNow();
                }
                System.out.println(a);
            });
        }

    }


    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
