package com.chenxi.test.utils;

import com.chenxi.test.sort.User;

import java.util.Comparator;

/**
 * Created by Administrator on 2016/8/28.
 */
public class ComparatorUser implements Comparator<User> {

    public int compare(User u1, User u2) {
        return u1.getAge() - u2.getAge();
    }

}
