package com.chenxi.test.easycoding;

import java.lang.ref.SoftReference;

public class SoftReferenceWhenIdle {
    public static void main(String[] args) {
        House seller = new House();
        SoftReference<House> buyer2 = new SoftReference<House>(seller);

        seller = null;

        while (true) {
            System.gc();
            System.runFinalization();

            if (buyer2.get() == null) {
                System.out.println("house is null.");
                break;
            } else {
                System.out.println("still there");
            }
        }
    }
}
