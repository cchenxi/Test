package com.chenxi.test.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流测试代码
 * Date: 2017-11-01
 *
 * @author chenxi
 */
public class StreamTest {
    public static List<Dish> MENU = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static void main(String[] args) {
        List<String> threeHighCaloricDishNames = MENU.stream()
                .filter(d -> {
                    System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishNames);

        MENU.stream().filter(d -> d.getCalories() > 300)
                .distinct()
                .limit(4)
                .skip(1)
                .forEach(System.out::println);

        //数值流
        int calories = MENU.stream().map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println(calories);

        int calories2 = MENU.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(calories);

        OptionalInt caloriesMin = MENU.stream().mapToInt(Dish::getCalories).min();
        System.out.println(caloriesMin.orElse(1));

        OptionalInt caloriesMax = MENU.stream().mapToInt(Dish::getCalories).max();
        System.out.println(caloriesMax.orElse(2));

        IntStream intStream = MENU.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        //数值范围
        System.out.println(IntStream.range(1, 100).filter(n -> n % 2 == 0).count());
        System.out.println(IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0).count());

        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                        );
    }
}
