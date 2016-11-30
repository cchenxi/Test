package com.chenxi.test.thread;

import org.omg.CORBA.INTERNAL;

/**
 * Created by chenxi on 16-11-30.
 */
public class TenThreads {
    private static class WorkerThread extends Thread {
        int max = Integer.MAX_VALUE;
        int[] ourArray;

        public WorkerThread(int[] ourArray) {
            this.ourArray = ourArray;
        }

        public void run() {
            for (int i = 0; i < ourArray.length; i++) {
                max = Math.max(max, ourArray[i]);
            }
        }

        public int getMax() {
            return max;
        }
    }

    private static int[][] getBigHairyMatrix() {
        int[][] result = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                result[i][j] = i * j;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        WorkerThread[] threads = new WorkerThread[10];
        int[][] bigMatrix = getBigHairyMatrix();
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            threads[i] = new WorkerThread(bigMatrix[i]);
            threads[i].start();
        }

        try {
            for (int i = 0; i < 10; i++) {
                threads[i].join();
                max = Math.max(max, threads[i].getMax());
            }
        } catch (InterruptedException e) {

        }

        System.out.println("Maximum value was " + max);
    }
}
