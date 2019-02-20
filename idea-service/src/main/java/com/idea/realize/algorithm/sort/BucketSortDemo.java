package com.idea.realize.algorithm.sort;


import java.util.*;

public class BucketSortDemo {

    public static void main(String[] args) {

        sort(new int[]{34, 6, 2, 36, 5, 20, 6, 2, 6, 6, 2, 66, 86, 5, 37, 56, 34});

    }


    public static void sort(int[] a) {
        System.out.println(Arrays.toString(a));
        //1.划分多少个桶
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }

        int num = (max - min) / 4 + 1;
        List<List> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(new ArrayList());
        }

        //2.往桶中放入数据
        for (int i = 0; i < a.length; i++) {
            int pos = (a[i] - min) / 4;
            list.get(pos).add(a[i]);
        }

        //3.桶内数据排序
        int count = 0;
        for (List thisBucket : list) {
            if (null != thisBucket && thisBucket.size() > 0) {
                Collections.sort(thisBucket);
                for (Object obj : thisBucket) {
                    a[count++] = (int) obj;
                }

            }
        }


        System.out.println(Arrays.toString(a));

    }
}
