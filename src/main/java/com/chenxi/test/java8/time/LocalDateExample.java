package com.chenxi.test.java8.time;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRulesException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/24.
 */
public class LocalDateExample {
    public static void main(String... args) {
        //当前日期
        LocalDate today = LocalDate.now();
        System.out.println("current date = " + today);

        //构造日期
        LocalDate firstDayOf2016 = LocalDate.of(2016, Month.JANUARY, 1);
        System.out.println("specific date = " + firstDayOf2016);

        //构造异常的日期
        try {
            LocalDate endDayOf2016 = LocalDate.of(2016, Month.DECEMBER, 32);
            System.out.println("specific date = " + endDayOf2016);
        } catch (DateTimeException e) {
            System.out.println(e.getMessage());
        }

        //指定时区
        LocalDate todayShanghai = LocalDate.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("today shanghai date = " + todayShanghai);
        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("today kolkata date = " + todayKolkata);

        //指定异常的时区
        try {
            LocalDate todayExcept = LocalDate.now(ZoneId.of("Asia/eee"));
            System.out.println("today except date = " + todayExcept);
        } catch (ZoneRulesException e) {
            System.out.println(e.getMessage());
        }

        String date = "2017-09";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            Date date1 = sdf.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            System.out.println(calendar.get(Calendar.MONTH) + 1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
