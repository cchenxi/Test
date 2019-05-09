package com.chenxi.test.language.collections.linkedList;

import com.alibaba.fastjson.JSON;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Author : Chen Xi
 * Date : 2016/9/16
 */
public class Test {

    public static void main(String[] args) {
        List<String> staff = new LinkedList<>();

        staff.add("a");
        staff.add("b");
        staff.add("c");

        Iterator iterator = staff.iterator();
        String a = iterator.next().toString();
        System.out.println(a);

        ListIterator listIterator = staff.listIterator();

        listIterator.next();
        listIterator.add("a+");
        System.out.println(JSON.toJSONString(staff));

        //next + remove
        listIterator.next();
        listIterator.remove();

        //previous + remove
        listIterator.previous();
        listIterator.remove();
        System.out.println(staff.toString());


    }
}
