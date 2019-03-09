package com.chenxi.test.books.taojcp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Deprecated {
    public static void main(String[] args) throws Exception {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(), "printThread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);

        printThread.suspend();
        System.out.println("main suspend printThread at " + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        printThread.resume();
        System.out.println("main resume printThread at " + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        printThread.stop();
        System.out.println("main stop pringThread at " + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
    }

    static class Runner implements Runnable {
        @Override
        public void run() {
            DateFormat format = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                System.out.println(Thread.currentThread().getName() + "Run at " + format.format(new Date()));
                SleepUtils.second(1);
            }
        }
    }
}
