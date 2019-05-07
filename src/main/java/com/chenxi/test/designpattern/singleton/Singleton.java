package com.chenxi.test.designpattern.singleton;

public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {
        System.out.println("生成了一个实例");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

class SingletonTest extends Thread {
    public static void main(String[] args) {
        new SingletonTest("A").start();
        new SingletonTest("A").start();
        new SingletonTest("A").start();
    }

    @Override
    public void run() {
        Singleton obj = Singleton.getInstance();
        System.out.println(getName() + ": obj = " + obj);
    }

    public SingletonTest(String name) {
        super(name);
    }
}
