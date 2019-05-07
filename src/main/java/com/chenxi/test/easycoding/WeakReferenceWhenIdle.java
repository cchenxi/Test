package com.chenxi.test.easycoding;

import java.lang.ref.WeakReference;

public class WeakReferenceWhenIdle {
    public static void main(String[] args) {
        House seller = new House();
        WeakReference<House> buyer3 = new WeakReference<House>(seller);
        seller = null;

        long startTime = System.nanoTime();
        int count = 0;
        while (true) {
            if (buyer3.get() == null) {
                long duration = (System.nanoTime() - startTime) / (1000 * 1000);
                System.out.println("house is null and exited time = " + duration + "ms");
                break;
            } else {
                System.out.println("still there. count = " + (count++));
            }
        }
    }
}
