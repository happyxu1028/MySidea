package com.idea.realize.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSortDemo {

    public static void main(String[] args) {
        sort(new int[]{23,15,12,64,2,10,34,1001});

    }

    public static void sort(int[] a){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++){
            max = Math.max(max,a[i]);
        }

        int keysNum = 0;
        while(max > 0 ){
            max /= 10;
            keysNum++;
        }



        for(int i =0; i < keysNum; i++){

            List<List> bucket = new ArrayList<>(10);
            for(int bucketIndex = 1; bucketIndex <= 10; bucketIndex++){
                bucket.add(new ArrayList());
            }

            for(int j = 0; j < a.length;j++){
                int key = a[j] % (int)Math.pow(10,i+1) / (int)Math.pow(10,i);
                bucket.get(key).add(a[j]);
            }

            int count = 0;
            for(int k = 0; k < 10; k++){
                List thisBucket = bucket.get(k);
                for (Object obj : thisBucket) {
                    a[count++] = (int)obj;
                }

            }
            System.out.print("第"+(i+1)+"轮排序：");
            System.out.println(Arrays.toString(a));
        }

    }
}
