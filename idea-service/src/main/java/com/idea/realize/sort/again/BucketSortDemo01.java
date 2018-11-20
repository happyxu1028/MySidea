package com.idea.realize.sort.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 */
public class BucketSortDemo01 {

    public static void main(String[] args) {
        sort(new int[]{34,6,2,36,5,20,6,2,6,6,2,66,86,5,37,56,34});

    }


    public static void sort(int[] a) {
        System.out.println(Arrays.toString(a));
        // 分桶
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int thisValue : a) {
            min = Math.min(thisValue, min);
            max = Math.max(thisValue, max);
        }

        int num = (max - min)/4 + 1;
        List<List> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(new ArrayList());
        }

        // 入桶
        for (int thisValue : a) {
            int bucketIndex = (thisValue-min)/4;
            list.get(bucketIndex).add(thisValue);
        }

        // 分桶排序
        int count = 0;
        for (List thisList : list) {
            Collections.sort(thisList);
            if(!thisList.isEmpty()){
                for (Object o : thisList) {
                    a[count++] = (int)o;
                }

            }
        }



        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(a));
    }
}
