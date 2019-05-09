package com.chenxi.test.language.collections.linkedList;

import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * LinkedList
 */
public class Test2 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(JSON.toJSONString(list));
    }
}
