package com.chenxi.test.language.collections.arraylist;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * ArrayList
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("e");
        list.add("f");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("e");
        list.add("f");

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("e");
        list.add("f");

        String s = list.set(0, "x");

        System.out.println(s);
        System.out.println(JSON.toJSONString(list));
    }
}
