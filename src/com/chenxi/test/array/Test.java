package com.chenxi.test.array;


import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/14.
 */
public class Test {

    public static void main(String[] args) {
        int smallPrimes[] = {1, 2, 3};
        int luckyNumber[] = smallPrimes;
        int copiedLuckyNumber[] = Arrays.copyOf(luckyNumber, luckyNumber.length);

        for(int i = 0; i < copiedLuckyNumber.length; i++) {
            System.out.println(copiedLuckyNumber[i]);
        }
    }
}
