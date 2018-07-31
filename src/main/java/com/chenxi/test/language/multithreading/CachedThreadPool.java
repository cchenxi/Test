package com.chenxi.test.language.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO: description
 * Date: 2018-07-27
 *
 * @author chenxi
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 1; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();
    }
}
