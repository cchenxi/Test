package com.chenxi.test.designpattern.singleton;

public class Triple {
    private static Triple[] singleton = new Triple[]{
            new Triple(0),
            new Triple(1),
            new Triple(2)
    };

    private int id;

    private Triple(int id) {
        System.out.println("this instance " + id + " is created!");
        this.id = id;
    }

    public static Triple getInstance(int id) {
        return singleton[id];
    }

    @Override
    public String toString() {
        return "Triple{" +
                "id=" + id +
                '}';
    }
}

class TripleTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Triple triple = Triple.getInstance(i % 3);
            System.out.println(triple);
        }
    }
}
