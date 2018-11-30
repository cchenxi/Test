package com.chenxi.test.prepare.tuniu;

public class TryCatchFinally {
    public static void main(String[] args) {
        int i = ret();
        System.out.println(i);
    }

    public static int ret() {
        int i = 0;
        try {
            i = 1/0;
            return i;
        } catch (Exception e) {
            return 1;
        } finally {
            i = 2;
        }
    }
}
