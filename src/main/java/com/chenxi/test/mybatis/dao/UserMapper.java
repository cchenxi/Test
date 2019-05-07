package com.chenxi.test.mybatis.dao;

import java.util.List;

public interface UserMapper {
    List<User> selectUser1(int id);
    List<User> selectUser2(int id);
    List<User> selectUser3(int id);
    int insertUser(User user);
}
