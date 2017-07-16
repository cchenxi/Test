package com.chenxi.test.language.ArrayList;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO : description
 * Author : Chen Xi
 * Date : 2016/9/11
 */
public class Test2<E> {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            products.add(new Product(i, "product_" + i, i));
        }

        products = products.subList(0, 12);

        System.out.println(JSON.toJSONString(products));
    }

    public static class Product {
        private int id;
        private String name;
        private float price;

        public Product(int id, String name, float price) {
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

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }
    }
}
