package com.chenxi.test.sort;

import com.alibaba.fastjson.JSON;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {10, 8, 9, 2, 5, 4, 7};
        int i = 0, j = 0, min = 0;
        int n = array.length;
        for (i = 0; i < n - 1; i++) {
            min = i;
            for (j = i + 1; j <= n-1; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = array[min];
                array[min] = array[i];
                array[i] = tmp;
            }
            System.out.println(JSON.toJSONString(array));
        }

        System.out.println(JSON.toJSONString(array));
    }
}
