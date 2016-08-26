package com.chenxi.test.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/8/14.
 */
public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.println("What is the highest number you can draw?");
        int n = in.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            int r = (int)(Math.random() * n);

            result[i] = numbers[r];
            numbers[r] = numbers[r - 1];
            n--;
        }

        Arrays.sort(result);
        System.out.println("Bet the following combination,it will make you rich!");
        for (int r : result) {
            System.out.println(r);
        }
    }
}
