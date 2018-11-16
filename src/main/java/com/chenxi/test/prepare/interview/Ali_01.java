package com.chenxi.test.prepare.interview;

import redis.clients.jedis.Jedis;

//1. 登录接口, 同一个人十分钟内连续登录5次失败,需要等待30分钟才能尝试登录。
public class Ali_01 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost",6379);

        //用户userId第一次登录，设置10分钟过期时间
        String userId = "userId";
        jedis.set(userId, "0");
        jedis.expire(userId, 10 * 60);


        //模拟5次登录失败
        for (int i = 0; i < 5; i++) {
            doLoginFail(jedis, userId);
        }
    }

    private static void doLoginFail(Jedis jedis, String key) {
        jedis.incr(key);
        //获取登录次数
        Integer loginTimes = Integer.valueOf(jedis.get(key));
        if (loginTimes >= 5) {
            jedis.expire(key, 30 * 60);
        }
    }
}
