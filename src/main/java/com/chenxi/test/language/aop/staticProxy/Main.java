package com.chenxi.test.language.aop.staticProxy;

public class Main {

    public static void main(String[] args) {
        IUserIao proxy = new UserDaoProxy();
        proxy.save();
        proxy.find();
    }
}
