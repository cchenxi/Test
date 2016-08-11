package com.chenxi.number;

/**
 * Created by Administrator on 2016/8/11.
 */
public class Test {
    /**
     * 根据分数确定星际
     * @param score
     * @return
     */
    private static double getStar(double score) {
        double star = 0;
        if (score<=10) {
            star = 0.5;
        } else if (score <= 20) {
            star = 1;
        } else if (score <= 30) {
            star = 1.5;
        } else if (score <= 40) {
            star = 2;
        } else if (score <= 50) {
            star = 2.5;
        } else if (score <= 60) {
            star = 3;
        } else if (score <= 70) {
            star = 3.5;
        } else if (score <= 80) {
            star = 4;
        } else if (score <= 90) {
            star = 4.5;
        } else if (score <= 100) {
            star = 5;
        } else {
            star = 0;
        }
        return star;
    }

    public static void main(String[] args) {
        double score = 61;
        System.out.println(Test.getStar(score));
    }
}
