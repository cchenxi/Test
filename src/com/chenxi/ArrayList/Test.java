package com.chenxi.ArrayList;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/23.
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        //确保数组列表在不重新分配存储空间的情况下能够保存给定数量的元素
        products.ensureCapacity(1000);
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId(i);
            product.setName("product_" + i);
            product.setPrice(10 * i);
            products.add(product);
        }
        //将数组列表的存储容量削减到当前尺寸
        products.trimToSize();
        System.out.println(products.size());
    }

    public static class Product {
        private int id;
        private String name;
        private float price;

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
