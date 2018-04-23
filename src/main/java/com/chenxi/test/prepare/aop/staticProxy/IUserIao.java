package com.chenxi.test.prepare.aop.staticProxy;

public interface IUserIao {
    void save();
    void find();
}

class UserDao implements IUserIao {
    @Override
    public void save() {
        System.out.println("模拟：保存用户！");
    }

    @Override
    public void find() {
        System.out.println("模拟：查询用户！");
    }
}

class UserDaoProxy implements IUserIao {

    private IUserIao target = new UserDao();

    @Override
    public void save() {
        System.out.println("代理操作：开启事务...");
        target.save();
        System.out.println("代理操作：提交事务...");
    }

    @Override
    public void find() {
        target.find();
    }
}
