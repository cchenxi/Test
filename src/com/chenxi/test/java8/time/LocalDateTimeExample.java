package com.chenxi.test.java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Administrator on 2016/12/24.
 */
public class LocalDateTimeExample {

    public static void main(String[] args) {
        //当前时间
        LocalDateTime today = LocalDateTime.now();
        System.out.println("current dateTime = " + today);

        today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("current dateTime = " + today);
    }
}
