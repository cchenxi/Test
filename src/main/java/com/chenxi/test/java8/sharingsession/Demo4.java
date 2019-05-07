package com.chenxi.test.java8.sharingsession;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo4 {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product(1, "南京3日游"),
                new Product(1, "上海2日游"),
                new Product(2, "苏州2日游"),
                new Product(3, "杭州4日游")
        );

        //collect
        Set<Integer> ids = productList.stream().map(Product::getId).collect(Collectors.toSet());
        Map<Integer, Product> productMap1 = productList.stream().collect(Collectors.toMap(Product::getId, Function.identity()));
        Map<Integer, Product> productMap2 = productList.stream().collect(Collectors.toMap(Product::getId, Function.identity(), (p1, p2) -> p1));
    }

    public static class Product {
        private int id;
        private String name;
        private BigDecimal price;

        public Product() {}

        public Product(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Product(int id, String name, BigDecimal price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }
    }
}
