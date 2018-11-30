package com.chenxi.test.mybatis.dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSON;

public class Test {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = Utils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.selectUser1(1);
        User user2 = sqlSession.selectOne("com.chenxi.test.mybatis.dao.UserMapper.selectUser", 1);
        System.out.println(JSON.toJSONString(user1));
        System.out.println(JSON.toJSONString(user2));
    }
}
