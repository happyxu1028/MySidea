package com.idea.realize.sort;

import java.util.Arrays;

public class SelectSortDemo {

    public static void main(String[] args) {
        selectSort(new int[]{1, 435, 16, 2, 6, 346});
    }


    public static void selectSort(int[] a) {
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }

            if (i != index) {
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
