package com.chenxi.test.language.aop.dynamicProxy;

public class Main {
    public static void main(String[] args) {
        IUserIao target = new UserDao();
        System.out.println("目标对象：" + target.getClass());
        IUserIao proxy = (IUserIao) new ProxyFactory(target).getProxyInstance();
        System.out.println("代理对象：" + proxy.getClass());
        proxy.save();
        proxy.find();
    }
}
