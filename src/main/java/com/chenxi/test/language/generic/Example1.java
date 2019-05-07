package com.chenxi.test.language.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2018-02-26
 *
 * @author chenxi
 */
public class Example1 {
    public static void main(String[] args) {
//        List arrayList = new ArrayList();
//        arrayList.add(12);
//        arrayList.add("asd");
//
//        for (int i = 0; i < arrayList.size(); i++) {
//            String item = (String) arrayList.get(i);
//            System.out.println("泛型测试 item:" + item);
//        }

        List<String> stringArrayList = new ArrayList<>();
        List<Integer> IntegerArrayList = new ArrayList<>();

        Class stringArrayListClass =stringArrayList.getClass();
        Class integerArrayListClass = IntegerArrayList.getClass();
        if (stringArrayListClass.equals(integerArrayListClass)) {
            System.out.println("泛型测试：类型相同");
        }
    }
}
