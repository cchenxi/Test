package com.chenxi.test.redis;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        RedisClient redisClient = new RedisClient("127.0.0.1", 6379);
        redisClient.set("hello", "helloXXXX");
        redisClient.get("hello");
    }
}
