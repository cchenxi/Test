package com.chenxi.test.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import com.alibaba.fastjson.JSON;

/**
 * 苹果
 * Date: 2017-11-01
 *
 * @author chenxi
 */
public class Apple extends Fruit {
    private int id;

    public Apple() {
    }

    public Apple(int id) {
        this.id = id;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static void main(String[] args) {

        List<Apple> appleList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Apple apple = new Apple();
            apple.setId(i);
            appleList.add(apple);
        }

        appleList.sort(Comparator.comparing(Apple::getId).reversed());
        System.out.println(JSON.toJSONString(appleList));

        List<String> str = Arrays.asList("a", "b", "d", "c");
        str.sort(String::compareTo);

        Supplier<Apple> c1 = Apple::new;
        Apple apple1 = c1.get();

        Function<Integer, Apple> c2 = Apple::new;
        Apple apple2 = c2.apply(2);
    }
}
