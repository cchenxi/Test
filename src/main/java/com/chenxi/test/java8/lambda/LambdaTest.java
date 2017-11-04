package com.chenxi.test.java8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleFunction;
import java.util.function.Function;


/**
 * lambda test
 * Date: 2017-11-01
 *
 * @author chenxi
 */
public class LambdaTest {

    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();

    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    public static Fruit giveMeFruit(String fruit, Integer id) {
        return map.get(fruit.toLowerCase()).apply(id);
    }

    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"));

        try {
            return bufferedReaderProcessor.process(bufferedReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bufferedReader.close();
        return null;
    }

    public static double integrate(DoubleFunction<Double> f, double a, double b) {
        return (f.apply(a) + f.apply(b)) * Math.abs(a - b) / 2.0;
    }

    public static void main(String[] args) {
        DoubleFunction<Double> f = (double x) -> x + 10;
        System.out.println(integrate(f, 3, 7));
    }
}
