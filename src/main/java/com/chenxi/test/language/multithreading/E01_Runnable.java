package com.chenxi.test.language.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * TODO: description
 * Date: 2018-07-27
 *
 * @author chenxi
 */
class Printer implements Runnable {

    private static int taskCount;
    private final int id  = taskCount++;

    Printer() {
        System.out.println("Printer started, ID = " + id);
    }

    @Override
    public void run() {
        System.out.println("Stage 1 ...., ID = " + id);
        Thread.yield();
        System.out.println("Stage 2 ...., ID = " + id);
        Thread.yield();
        System.out.println("Stage 3 ...., ID = " + id);
        Thread.yield();

        System.out.println("Printer ended, ID = " + id);
    }
}

class A implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "haha";
    }
}

public class E01_Runnable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(new Printer()).start();
        }

        FutureTask<String> futureTask = new FutureTask<>(new A());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
