package com.chenxi.test.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

/**
 * TODO: description
 * Date: 2017-11-02
 *
 * @author chenxi
 */
public class FlatMapTest {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        System.out.println(words.stream().map(String::length).collect(Collectors.toList()));
        System.out.println(JSON.toJSONString(words.stream().map(word -> word.split("")).distinct().collect(Collectors.toList())));

        System.out.println(JSON.toJSONString(words.stream().map(word -> word.split("")).map(Arrays::stream).distinct().collect(Collectors.toList())));
        System.out.println(JSON.toJSONString(
                words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList())
        ));

        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);

        System.out.println(JSON.toJSONString(
                number1.stream().flatMap(
                        i -> number2.stream().map(j -> new int[]{i, j})
                ).collect(Collectors.toList())
        ));

        System.out.println(JSON.toJSONString(
                number1.stream().flatMap(
                        i -> number2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})
                ).collect(Collectors.toList())
        ));
    }
}
