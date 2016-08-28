package com.chenxi.test.sort;

import com.alibaba.fastjson.JSON;
import com.chenxi.test.utils.ComparatorUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2016/8/28.
 */
public class Test {
    public static void main(String... args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "book"));
        products.add(new Product(5, "pen"));
        products.add(new Product(3, "paper"));

        Collections.sort(products);

        System.out.println(JSON.toJSONString(products));


        List<User> users = new ArrayList<>();
        users.add(new User(1, "chenxi", 26));
        users.add(new User(2, "haha", 29));
        users.add(new User(3, "huanhuan", 27));

        ComparatorUser comparatorUser = new ComparatorUser();
        Collections.sort(users, comparatorUser);
        System.out.println(JSON.toJSONString(users));

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getId() - o1.getId();
            }
        });

        System.out.println(JSON.toJSONString(users));
    }
}
