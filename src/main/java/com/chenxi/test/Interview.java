package com.chenxi.test;

import java.util.Random;

public class Interview {
    /**
     * 移除数组中的重复数字
     *
     * @param input
     * @param n
     * @return
     */
    private static int removeRepetitiveNumbers(int[] input, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int resultLength = input.length;
        for (int i = 0; i < resultLength; i++) {
            for (int j = i + 1; j < resultLength; j++) {
                //重复 则放置到最后，同时元素总数-1，j回退一位
                if (input[i] == input[j]) {
                    input[j] = input[resultLength - 1];
                    resultLength--;
                    j--;
                }
            }
        }
        return resultLength;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int length = 20;
        int bound = 15;
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = random.nextInt(bound);
        }

        length = removeRepetitiveNumbers(intArray, length);
        for (int i = 0; i < length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }
}
