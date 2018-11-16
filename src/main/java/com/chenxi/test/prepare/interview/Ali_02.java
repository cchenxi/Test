package com.chenxi.test.prepare.interview;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//2. 实现一个生产者消费者模式，要求：多个生产者、一个消费者，在保证逻辑正确的前提下，尽可能提高生产和消费的性能
public class Ali_02 {
    public static void main(String[] args) {
        //队列
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);

        //生产者线程池
        ExecutorService produceExecutor = new ThreadPoolExecutor(
                4,
                16,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(50),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        //消费者线程池
        ExecutorService consumeExecutor = Executors.newSingleThreadExecutor();

        //生产者任务，队列入队
        Runnable producerTask = () -> {
            try {
                int value = 0;
                while (true) {
                    blockingQueue.put(value);
                    System.out.println("produced " + value + " thread:" + Thread.currentThread().getId());
                    value++;
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //消费者任务 队列出队
        Runnable consumerTask = () -> {
            try {
                while (true) {
                    System.out.println("consume:" + blockingQueue.take() + " thread:" + Thread.currentThread().getId());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        produceExecutor.execute(producerTask);
        produceExecutor.execute(producerTask);

        consumeExecutor.execute(consumerTask);

        produceExecutor.shutdown();
        consumeExecutor.shutdown();
    }
}
