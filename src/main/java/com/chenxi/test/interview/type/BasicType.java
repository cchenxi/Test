package com.chenxi.test.interview.type;

/**
 * Date: 2018-09-08
 *
 * @author chenxi
 */
public class BasicType {
    public static void main(String[] args) {
        System.out.println(Byte.SIZE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);

       String a = "a";

        switch (a) {
            case "a":
                System.out.println(1);
                break;
            default:
                System.out.println(2);
                break;

        }

    }
}
