package com.chenxi.test.java8.sharingsession;

import java.util.Arrays;
import java.util.OptionalInt;

public class Demo3 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        OptionalInt sum1 = Arrays.stream(array).reduce((a, b) -> a + b);
        OptionalInt sum2 = Arrays.stream(array).reduce(Integer::sum);
        int sum3 = Arrays.stream(array).reduce(100, Integer::sum);
    }
}
