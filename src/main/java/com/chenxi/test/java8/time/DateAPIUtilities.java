package com.chenxi.test.java8.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by Administrator on 2016/12/24.
 */
public class DateAPIUtilities {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        //获取年份 判断是否闰年
        System.out.println("Year " + today.getYear() + " is Leap year? " + today.isLeapYear());

        //比较两天
        System.out.println("Today is before 01/01/2017? " + today.isBefore(LocalDate.of(2017,1,1)));

        //currentLocalDateTime from LocalDate
        System.out.println("current time = " + today.atTime(LocalTime.now()));

        //日期加减
        System.out.println("10 days after today is " + today.plusDays(10));
        System.out.println("3 weeks after today is " + today.plusWeeks(3));
        System.out.println("20 months after today is " + today.plusMonths(20));
        System.out.println("10 years after today is " + today.plusYears(10));

        System.out.println("10 days before today is " + today.minusDays(10));
        System.out.println("3 weeks before today is " + today.minusWeeks(3));
        System.out.println("20 months before today is " + today.minusMonths(20));
        System.out.println("10 years before today is " + today.minusYears(10));

        //
        System.out.println("First date of this month is " + today.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("Last date of this year is " + today.with(TemporalAdjusters.lastDayOfYear()));

        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        Period period = today.until(lastDayOfYear);
        System.out.println("period format = " + period);
        System.out.println("days remaining in the year = " + period.getDays());

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println(tomorrow);
    }
}
