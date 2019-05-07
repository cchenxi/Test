package com.chenxi.test.java8.sharingsession;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

public class Demo5 {
    public static void main(String[] args) {
        List<Demo4.Product> productList = Arrays.asList(
                new Demo4.Product(1, "南京3日游", new BigDecimal(3000)),
                new Demo4.Product(4, "上海2日游", new BigDecimal(4000)),
                new Demo4.Product(2, "苏州2日游", new BigDecimal(5000)),
                new Demo4.Product(3, "杭州4日游", new BigDecimal(3500))
        );

        productList.sort(Comparator.comparingInt(Demo4.Product::getId));
        System.out.println(JSON.toJSONString(productList));

        List<Demo4.Product> productList1
                = productList.stream().sorted(Comparator.comparing(Demo4.Product::getPrice)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(productList1));
    }
}
