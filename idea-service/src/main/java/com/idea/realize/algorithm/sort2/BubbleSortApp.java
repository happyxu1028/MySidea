package com.idea.realize.algorithm.sort2;

import java.util.Arrays;

public class BubbleSortApp {

    public static void main(String[] args) {
        sort(new int[]{12,3,5,232,4,4142,51,9},8);

    }

    public static void sort(int[] arr, int length){
        for(int i = 0; i < length; i++){
            boolean isChange = false;
            for(int j = 0; j < length-i-1; j++){
                if(arr[j+1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1] ;
                    arr[j+1] = temp;
                    isChange = true;
                }
            }

            if(!isChange){
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

}
