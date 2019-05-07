package com.chenxi.test.language.map;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.alibaba.fastjson.JSON;

public class HashMapMulti extends Thread {
    static HashMap<Integer, Integer> map = new HashMap<>(2);
    static AtomicInteger at = new AtomicInteger();

    @Override
    public void run() {
        while (at.get() < 100000) {
            map.put(at.get(), at.get());
            at.incrementAndGet();
        }
        System.out.println(JSON.toJSONString(map));
    }
}
