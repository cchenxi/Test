package com.chenxi.test.language.string;

import java.lang.reflect.Field;

public class StringStudy_02 {

    public static void testReflection() throws Exception {
        String s = "Hello world";
        System.out.println("s = " + s);

        Field valueFieldOfString = String.class.getDeclaredField("value");
        valueFieldOfString.setAccessible(true);

        char[] value = (char[]) valueFieldOfString.get(s);
        value[5] = '_';
        System.out.println("s = " + s);
    }

    public static void main(String[] args) throws Exception {
        testReflection();
    }
}
