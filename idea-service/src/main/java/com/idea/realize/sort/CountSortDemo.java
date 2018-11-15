package com.idea.realize.sort;

import java.util.Arrays;

public class CountSortDemo {

    public static void main(String[] args) {
        sort(new int[]{34,6,2,36,5,20,6,10,6,16,2,66,86,5,37,56,34});

    }


    public static void sort(int[] a){
        System.out.println(Arrays.toString(a));
        //1.分桶放入数据
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++){
            max = Math.max(max,a[i]);
        }

        int[] bucket = new int[max+1];
        for(int i = 0;i < bucket.length; i++){
            bucket[i] = 0;
        }

        for(int i = 0; i < a.length; i++){
            bucket[a[i]]++;
        }

        //2.从头到位次序累加
        for(int i =1; i <= max; i++){
            bucket[i] = bucket[i-1]+bucket[i];
        }

        //3.申请新数组,进行排序
        int[] result = new int[a.length];
        for(int i = a.length-1; i >= 0; i--){
            int index = bucket[a[i]]-1;
            result[index] = a[i];
            bucket[a[i]]--;
        }


        System.out.println(Arrays.toString(result));
    }
}
