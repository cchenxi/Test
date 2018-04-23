package com.chenxi.test.prepare.aop.staticProxy;

public class Main {

    public static void main(String[] args) {
        IUserIao proxy = new UserDaoProxy();
        proxy.save();
        proxy.find();
    }
}
