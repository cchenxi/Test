package com.chenxi.test.language.reflect;

/**
 * Created by chenxi on 2017/10/22.
 */
public class ClassDemo {

    public static void main(String[] args) {
        Foo f1 = new Foo();
        Class c1 = Foo.class;

        Class c2 = f1.getClass();

        Class c3 = null;
        try {
            c3 = Class.forName("com.chenxi.test.language.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c1 == c2);
        System.out.println(c2 == c3);

        try {
            Foo foo = (Foo) c1.newInstance();
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Foo {
    void print() {
        System.out.println("foo");
    }
}
