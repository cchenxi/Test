package com.chenxi.test.language.thread;

import java.util.Date;

/**
 * TimePrinter
 * Date : 2016/12/2
 *
 * @author : chenxi<chenxi.et@gmail.com>
 */
public class TimePrinter extends Thread {
    int pauseTime;
    String name;

    public TimePrinter(int x, String n) {
        pauseTime = x;
        name = n;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(name + ":" + new Date(System.currentTimeMillis()));
                Thread.sleep(pauseTime);
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        TimePrinter tp1 = new TimePrinter(5000, "Fast Guy");
        tp1.start();
        TimePrinter tp2 = new TimePrinter(10000, "Slow Guy");
        tp2.start();
    }
}
