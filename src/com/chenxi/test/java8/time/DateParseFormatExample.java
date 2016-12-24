package com.chenxi.test.java8.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Created by Administrator on 2016/12/24.
 */
public class DateParseFormatExample {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        System.out.println("default format of LocalDate = " + date);

        //格式化
        System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));

        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("default format of LocalDateTime = " + dateTime);

        //格式化
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MM::uuuu HH::mm::ss")));
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

        Instant timestamp = Instant.now();
        System.out.println("default format of Instant = " + timestamp);

        try {
            LocalDateTime dt = LocalDateTime.parse("27::Apr::2016 22::02::10",
                    DateTimeFormatter.ofPattern("d::MM::uuuu HH::mm::ss"));
            System.out.println("default format after parsing = " + dt);
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }

    }
}
