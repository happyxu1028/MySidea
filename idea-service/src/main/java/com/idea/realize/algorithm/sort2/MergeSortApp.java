package com.idea.realize.algorithm.sort2;

import java.util.Arrays;

public class MergeSortApp {


    public static void main(String[] args) {
        mergeArr(new int[]{12,234,52,2,5,6,51,37,25,6,36,2});
    }

    public  static void mergeArr(int[] a){

        mergeSplit(a,0,a.length-1);
    }

    private static void mergeSplit(int[] a, int lowIndex, int highIndex) {

        if(lowIndex == highIndex){
            return;
        }

        int midIndex = (lowIndex + highIndex) / 2;
        mergeSplit(a,lowIndex,midIndex);
        mergeSplit(a,midIndex+1,highIndex);

        merge(a,lowIndex,midIndex,highIndex);
        System.out.println(Arrays.toString(a));

    }

    private static void merge(int[] a, int lowIndex, int midIndex, int highIndex) {
        int[] tempArr = new int[a.length];
        int i = lowIndex;
        int j = midIndex+1;
        int k = 0;
        while(i <= midIndex && j <= highIndex){
            if(a[i] < a[j]){
                tempArr[k++] = a[i++];
            }else{
                tempArr[k++] = a[j++];
            }
        }


        int start = i;
        int end = midIndex;
        if( j <highIndex){
            start = j;
            end = highIndex;
        }

//       for(;start <= end; start++){
////           tempArr[k++] = a[start];
////       }
        while((start) <= end){
            tempArr[k++] = a[start++];
        }

        for(int t =0; t < k; t++){
            a[lowIndex+t] = tempArr[t];
        }

    }
}
