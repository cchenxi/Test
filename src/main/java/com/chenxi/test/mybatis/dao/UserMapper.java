package com.chenxi.test.mybatis.dao;

public interface UserMapper {
    User selectUser1(int id);
    User selectUser2(int id);
    int insertUser(User user);
}
