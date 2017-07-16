package com.chenxi.test.language.string;

/**
 * 格式化输出
 * Created by Administrator on 2016/8/10.
 */
public class OutputTest {
    public static void main(String[] args) {
        System.out.printf("hello, %s .you are %d", "chenxi", 26);
        System.out.println("");
        System.out.printf("%,.2f", 10000.0 / 3);
        System.out.println("");
        System.out.printf("%,(.2f", 10000.0 / 3);
        System.out.println("");
        //String.format()创建格式化的字符串，不打印输出
        String name = "chenxi";
        int age = 26;
        String message = String.format("Hello, %s, you are %d", name, age);
    }
}
