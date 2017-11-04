package com.chenxi.test.language.reflect;

/**
 * Created by chenxi on 2017/10/22.
 */
public class Office {
    public static void main(String[] args) {
        if ("Word".equals(args[0])) {
            Word w = new Word();
            w.start();
        }
        if ("Excel".equals(args[0])) {
            Excel e = new Excel();
            e.start();
        }
    }
}
