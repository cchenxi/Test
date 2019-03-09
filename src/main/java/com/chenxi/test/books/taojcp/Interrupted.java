package com.chenxi.test.books.taojcp;

import java.util.concurrent.TimeUnit;

public class Interrupted {
    public static void main(String[] args) throws Exception {
        Thread sleepThread = new Thread(new SleepRunner(), "sleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "busyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);

        System.out.println("sleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("busyThread interrupted is " + busyThread.isInterrupted());

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("sleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("busyThread interrupted is " + busyThread.isInterrupted());

        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
