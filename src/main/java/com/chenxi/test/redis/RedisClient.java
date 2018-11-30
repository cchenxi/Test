package com.chenxi.test.redis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RedisClient {
    OutputStream outputStream;
    InputStream inputStream;

    public RedisClient(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        outputStream = socket.getOutputStream();
        inputStream = socket.getInputStream();
    }

    public void set(String key, String value) throws IOException {
        StringBuffer data = new StringBuffer();
        data.append("*3").append("\r\n");
        data.append("$3").append("\r\n");
        data.append("SET").append("\r\n");
        data.append("$").append(key.getBytes().length).append("\r\n");
        data.append(key).append("\r\n");
        data.append("$").append(value.getBytes().length).append("\r\n");
        data.append(value).append("\r\n");

        outputStream.write(data.toString().getBytes());
        System.out.println("send success");
        System.out.println(data);
        byte[] response = new byte[1024];
        inputStream.read(response);
        System.out.println("接收到响应：" + new String(response));
    }

    public void get(String key) throws IOException {
        StringBuffer data = new StringBuffer();
        data.append("*2").append("\r\n");
        data.append("$3").append("\r\n");
        data.append("GET").append("\r\n");
        data.append("$").append(key.getBytes().length).append("\r\n");
        data.append(key).append("\r\n");

        outputStream.write(data.toString().getBytes());
        System.out.println("get success");
        System.out.println(data);
        byte[] response = new byte[1024];
        inputStream.read(response);
        System.out.println("接收到响应：" + new String(response));
    }
}
