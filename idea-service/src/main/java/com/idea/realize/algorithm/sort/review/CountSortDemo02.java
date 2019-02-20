package com.idea.realize.algorithm.sort.review;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountSortDemo02 {


    public static void main(String[] args) {
        sort(new int[]{34, 6, 2, 36, 5, 20, 6, 10, 6, 16, 2, 66, 86, 5, 37, 56, 34});

    }

    public static void sort(int[] a) {
        System.out.println(Arrays.toString(a));
        //1.分桶
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }

        int[] buckets = new int[max + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = 0;
        }

        //2.入桶
        for (int i = 0; i < a.length; i++) {
            buckets[a[i]]++;
        }

        //3.桶计数累加
        for (int i = 1; i < buckets.length; i++) {
            buckets[i] = buckets[i] + buckets[i - 1];
        }


        int[] result = new int[a.length];

        //4.排序
        for (int i = a.length - 1; i >= 0; i--) {
            int index = buckets[a[i]] - 1;
            result[index] = a[i];
            buckets[a[i]]--;
        }

        System.out.println(Arrays.toString(result));

    }

}
