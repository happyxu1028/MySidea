package com.idea.realize.algorithm.sort2;

import java.util.Arrays;

public class QuickSortApp {

    public static void main(String[] args) {

        quickSort(new int[]{8,7});
    }

    public static void quickSort(int[] a){
        quickSortSplit(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }


    private static void quickSortSplit(int[] a, int lowIndex, int highIndex) {
        if(lowIndex >= highIndex){
            return;
        }

        int midIndex = calMidIndex(a,lowIndex,highIndex);

        quickSortSplit(a,lowIndex,midIndex-1);

        quickSortSplit(a,lowIndex+1,highIndex);

    }

    private static int calMidIndex(int[] a, int lowIndex, int highIndex) {

        int value = a[highIndex];
        int i = lowIndex;
        for(int j = lowIndex; j < highIndex; j++){
            if(value > a[j]){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }

        int temp = a[i];
        a[i] = a[highIndex];
        a[highIndex] = temp;


        return i;

    }
}
