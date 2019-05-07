package com.chenxi.test.language.string;

public class StringStudy_04 {
    public static void main(String[] args) {
        String a = "a";
        String a1 = new String("a");
        String a2 = a1.trim() + "";
        String a3 = "a" + "";
        String a4 = "a".trim() + "";

        System.out.println(a == a1);
        System.out.println(a.intern() == a1.intern());
        System.out.println(a2 == a1);
        System.out.println(a3 == a);
        System.out.println(a4 == a);

        String i = "10";
        System.out.println(Integer.valueOf(i));
        System.out.println(Integer.parseInt(i));

        String str = "abcdefghijklmn";
        System.out.println(str.substring(0));
        System.out.println(str.substring(0, 1));
    }
}
