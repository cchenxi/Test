package com.chenxi.test.language.string;

import java.util.Scanner;

/**
 * Scanner
 * Created by Administrator on 2016/8/10.
 */
public class InputTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("what is your name?");
        String name = in.nextLine();

        System.out.println("how old are you?");
        int age = in.nextInt();

        System.out.println("hello, " + name + ". you are " + age);
    }
}
