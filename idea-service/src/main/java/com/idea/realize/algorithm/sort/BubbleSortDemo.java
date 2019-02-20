package com.idea.realize.algorithm.sort;

import java.util.Arrays;

public class BubbleSortDemo {

    public static void main(String[] args) {
        sort(new int[]{1, 435, 16, 2, 6, 346});
    }

    public static void sort(int[] a) {
        System.out.println(Arrays.toString(a));
        int length = a.length;
        for (int i = 0; i < length; i++) {
            boolean flag = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
                flag = false;
            }

            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(a));

    }
}
