package com.chenxi.test.java8.stream;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

public class FilterTest {
    public static void main(String[] args) {
        List<User> users = Collections.singletonList(new User(129));
        Integer id = 129;
        List<User> userList = users.stream().filter(user -> user.getId() == id).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(userList));
    }

    static class User {
        private Integer id;

        public User(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
