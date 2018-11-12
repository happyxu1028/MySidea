package com.idea.realize.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSortDemo {

    public static void main(String[] args) {
        sort(new int[]{1,435,16,2,6,346});
    }

    /**
     * 插入排序
     * @param a
     */
    public static void sort(int[] a){
        System.out.println(Arrays.toString(a));
        for(int i = 1; i < a.length; i++){
            //插入的值
            int value = a[i];

            //最后一个有序位置的索引
            int j = i-1;
            for(;j >=0; j--){
                if(a[j]>value){
                    a[j+1] = a[j];
                }else{
                    //本次排序完成
                    break;
                }
            }
            a[j+1] = value;
        }
        System.out.println(Arrays.toString(a));
    }
}
