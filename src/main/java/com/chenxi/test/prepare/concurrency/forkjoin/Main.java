package com.chenxi.test.prepare.concurrency.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1, 4);
        Future result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
        }
    }
}
