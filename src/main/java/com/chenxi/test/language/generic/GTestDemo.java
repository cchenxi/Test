package com.chenxi.test.language.generic;

import java.util.List;

public class GTestDemo {
    public void testAdd(List<? extends Animal> list) {
//        list.add(new Animal("animal"));
    }

    public void testAdd2(List<? super Animal> list) {

    }

    public static void main(String[] args) {

    }
}
