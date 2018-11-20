package com.chenxi.test.prepare.concurrency;

public class ThreadJoinTest {
    public static void main(String[] args) {
        ParentThread parentThread = new ParentThread();
        parentThread.start();
    }

    static class ParentThread extends Thread {
        @Override
        public void run() {
            ChildThread childThread = new ChildThread();
            childThread.start();
            //join start,加了join之后，会导致childThread都执行完毕才开始执行parentThread
            try {
                childThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //join end
            for (int i = 0; i < 1000; i++) {
                System.out.println("parent-" + i);
            }
        }
    }

    static class ChildThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println("child-" + i);
            }
        }
    }
}
