package com.chenxi.test.language.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @link {https://javahungry.blogspot.com/2014/12/5-ways-to-reverse-string-in-java-with-example.html}
 */
public class ReverseString {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        f1(input);
        f2(input);
        f3(input);
        f4(input);
        f5(input);
        f6(input);
    }

    public static void f1(String input) throws Exception {
        char[] c1 = input.toCharArray();
        char[] c2 = new char[c1.length];

        for (int i = c1.length - 1; i >= 0; i--) {
            c2[c1.length - i - 1] = c1[i];
        }

        System.out.println(new String(c2));
    }

    public static void f2(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();
        System.out.println(sb.toString());
    }

    public static void f3(String input) {
        char[] c1 = input.toCharArray();
        int left, right = 0;
        right = c1.length - 1;

        for (left = 0; left < right; left++, right--) {
            char temp = c1[left];
            c1[left] = c1[right];
            c1[right] = temp;
        }

        System.out.println(new String(c1));
    }

    public static void f4(String input) {
        char[] c1 = input.toCharArray();
        char[] c2 = new char[c1.length];
        List<Character> characters = new LinkedList<>();
        for (char c :
                c1) {
            characters.add(c);
        }
        Collections.reverse(characters);

        for (int i = 0; i < characters.size(); i++) {
            c2[i] = characters.get(i);
        }
        System.out.println(new String(c2));
    }

    public static void f5(String input) {
        System.out.println(reverseString(input));
    }

    private static String reverseString(String input) {
        if (input.isEmpty()) {
            return "";
        }
        return reverseString(input.substring(1)) + input.charAt(0);
    }

    public static void f6(String input) {
        byte[] b1 = input.getBytes();
        byte[] b2 = new byte[b1.length];

        for (int i = 0; i < b1.length; i++) {
            b2[i] = b1[b1.length -i -1];
        }

        System.out.println(new String(b2));
    }
}
