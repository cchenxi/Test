package com.chenxi.test.easycoding;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceHouse {
    public static void main(String[] args) {
        List<House> houses = new ArrayList<>();
//        List<SoftReference> houses = new arraylist<SoftReference>();
        int i = 0;
        while (true) {
            houses.add(new House());

//            SoftReference<House> buyer2 = new SoftReference<House>(new House());
//            houses.add(buyer2);

            System.out.println("i=" + i++);
        }

    }
}

class House {
    private static final Integer DOOR_NUMBER = 2000;
    public Door[] doors = new Door[DOOR_NUMBER];
    private String desc;

    public House() {

    }

    public House(String desc) {
        this.desc = desc;
    }

    class Door {}
}
