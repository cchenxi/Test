package com.chenxi.test.language.thread.threadlocal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(30, 300, 120L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(100),
                new BasicThreadFactory.Builder().namingPattern("test-thread-local-%d").build());

        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "this is thread local default value");

        System.out.println("before set, " + threadLocal.get() + Thread.currentThread().getName());

        executorService.execute(() -> {
            System.out.println("before set in pool, " + threadLocal.get() + Thread.currentThread().getName());
        });

        threadLocal.set("test time:" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        executorService.execute(() -> {
            System.out.println("after set in pool, " + threadLocal.get() + Thread.currentThread().getName());
        });

        System.out.println("after set, " + threadLocal.get() + Thread.currentThread().getName());
    }
}
