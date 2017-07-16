package com.chenxi.test.language.generic;

/**
 * 泛型学习
 * Author : Chen Xi
 * Date : 2016/8/30
 */
public class PairTest {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minMax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());

        System.out.println("mid = " + ArrayAlg.getMiddle(words));

        System.out.println(ArrayAlg.getMiddle(2.1, 3.15, 0.2));
    }
}

class ArrayAlg {
    public static Pair<String> minMax(String[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        String min = a[0];
        String max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }

    public static <T extends Comparable> Pair<T> minMax(T[] b) {
        if (b == null || b.length == 0) {
            return null;
        }
        T min = b[0];
        T max = b[0];

        for (int i = 0; i < b.length; i++) {
            if (min.compareTo(b[i]) > 0) {
                min = b[i];
            }
            if (max.compareTo(b[i]) < 0) {
                max = b[i];
            }
        }
        return new Pair<T>(min, max);
    }

    public static <T> T getMiddle(T...a) {
        return a[a.length / 2];
    }

    public static <T extends Comparable> T min(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T smallest = a[0];

        for (int i = 0; i < a.length; i++) {
            if (smallest.compareTo(a[i]) > 0) {
                smallest = a[i];
            }
        }
        return smallest;
    }
}
