package com.chenxi.test.java8.time;

import java.time.LocalTime;

/**
 * Created by Administrator on 2016/12/24.
 */
public class LocalTimeExample {
    public static void main(String[] args) {
        //当前时间
        LocalTime time = LocalTime.now();
        System.out.println("current time = " + time);
    }
}
