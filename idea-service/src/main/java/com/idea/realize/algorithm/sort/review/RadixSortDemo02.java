package com.idea.realize.algorithm.sort.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSortDemo02 {

    public static void main(String[] args) {
        sort(new int[]{23, 15, 12, 64, 2, 10, 34, 1001});

    }

    public static void sort(int[] a) {
        System.out.println(Arrays.toString(a));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }

        int keyNum = 0;
        while (max > 0) {
            max /= 10;
            keyNum++;
        }


        for (int i = 0; i < keyNum; i++) {
            //分桶
            List<List> list = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                list.add(new ArrayList());
            }

            for (int k = 0; k < a.length; k++) {
                int bucketKey = a[k] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                list.get(bucketKey).add(a[k]);
            }

            int count = 0;
            for (List thisList : list) {
                if (!thisList.isEmpty()) {
                    for (Object o : thisList) {
                        a[count++] = (int) o;
                    }

                }
            }

            System.out.println("第" + (keyNum + 1) + "轮排序结果: " + Arrays.toString(a));
        }


    }
}
