package com.chenxi.test.language.string;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class StringStudy_01 {
    public static void main(String[] args) throws Exception {
//        construct();
        valueOf();
    }

    private static void construct() throws Exception {
        //String的构造函数
        String a = "a";
        String b = new String(a);
        String c = new String(new char[]{'c'});
        String d = new String(new char[]{'d', 'e', 'f', 'g'}, 1, 2);
        String e = new String(new int[]{0x61, 0x62, 0x63, 0x64}, 1, 2);
        String f = new String(new byte[]{0x61, 0x62, 0x63, 0x64}, 0, 1, 2);
        String g = new String(new byte[]{0x61, 0x62, 0x63, 0x64}, 1);
        String h = new String(new byte[]{(byte) 0xe5, (byte) 0xad, (byte) 0x97, (byte) 0xe7,
                (byte) 0xac, (byte) 0xa6, (byte) 0xe7, (byte) 0xbc,
                (byte) 0x96, (byte) 0xe7, (byte) 0xa0, (byte) 0x81,}, 0, 12,
                "utf-8");
        String i = new String(new byte[]{(byte) 0xe5, (byte) 0xad, (byte) 0x97, (byte) 0xe7,
                (byte) 0xac, (byte) 0xa6, (byte) 0xe7, (byte) 0xbc,
                (byte) 0x96, (byte) 0xe7, (byte) 0xa0, (byte) 0x81,}, 0, 12,
                "utf-16");
        String j = new String(new byte[]{(byte) 0xe5, (byte) 0xad, (byte) 0x97, (byte) 0xe7,
                (byte) 0xac, (byte) 0xa6, (byte) 0xe7, (byte) 0xbc,
                (byte) 0x96, (byte) 0xe7, (byte) 0xa0, (byte) 0x81,}, 0, 12,
                Charset.forName("utf-8"));
        String k = new String(new byte[]{(byte) 0xe5, (byte) 0xad, (byte) 0x97, (byte) 0xe7,
                (byte) 0xac, (byte) 0xa6, (byte) 0xe7, (byte) 0xbc,
                (byte) 0x96, (byte) 0xe7, (byte) 0xa0, (byte) 0x81,}, 0, 12,
                Charset.forName("gbk"));
        String l = new String(new byte[]{(byte) 0xe5, (byte) 0xad, (byte) 0x97, (byte) 0xe7,
                (byte) 0xac, (byte) 0xa6, (byte) 0xe7, (byte) 0xbc,
                (byte) 0x96, (byte) 0xe7, (byte) 0xa0, (byte) 0x81,}, 0, 12,
                Charset.forName("gb2312"));


        System.out.println(a + b + c + d + e + f + g + h + i + j + k + l);
    }

    private static void valueOf() throws Exception {
        //object
        Map<String, Integer> obj = new HashMap();
        obj.put("a", 1);
        obj.put("b", 2);
        obj.put("c", 3);
        System.out.println(String.valueOf(obj));

    }
}
