package com.chenxi.test.java8.sharingsession;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

public class Demo1 {
    public static void main(String[] args) {
        List<String> productIds
                = Arrays.asList("500000241","210598502", "500000243", "210689412");
        System.out.println("产品编号列表：" + JSON.toJSONString(productIds));

        //filter
        List<String> temaiProductIds
                = productIds.stream().filter(id -> id.startsWith("5")).collect(Collectors.toList());
        System.out.println("特卖产品编号列表：" + JSON.toJSONString(temaiProductIds));

        //*match
        boolean containTemaiProductId = productIds.stream().anyMatch(id -> id.startsWith("5"));
        System.out.println((containTemaiProductId ? "含" : "不含") + "特卖产品");

        boolean allTemaiProductId = productIds.stream().allMatch(id -> id.startsWith("5"));
        System.out.println((allTemaiProductId ? "都是" : "不都是") + "特卖产品");

        boolean notContainBoss9ProductId = productIds.stream().noneMatch(id -> id.startsWith("9"));
        //假装存在以9开头的boss9系列产品
        System.out.println((notContainBoss9ProductId ? "不存在" : "存在") + "boss9产品");

        //find*
        Optional<String> productId = productIds.stream().findAny();
        System.out.println(productId.isPresent());
        productId.ifPresent(System.out::println);
        System.out.println(productId.get());
        System.out.println(productId.orElse(""));

        Optional<String> productId1 = productIds.stream().findFirst();

    }
}
