package com.chenxi.test.java8.stream;

import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * TODO: description
 * Date: 2017-11-06
 *
 * @author chenxi
 */
public class Collector {

    public static void main(String[] args) {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloriesDish = StreamTest.MENU.stream().collect(Collectors.maxBy(dishCaloriesComparator));

        System.out.println(mostCaloriesDish);

        GregorianCalendar gc = new GregorianCalendar();
        int t = gc.get(Calendar.DAY_OF_WEEK);
        System.out.println(t);
    }
}
