package com.idea.realize.javacore36.mapseries;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author happyxu
 * @Description: TODO
 * @Title: LinkedHashMapDemo
 * @ProjectName sidea
 * @date 2018/9/19下午9:21
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {

        LinkedHashMap linkedHashMap = new LinkedHashMap(16, 0.74F) {

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 2;
            }
        };

        linkedHashMap.put("1", "11");
        linkedHashMap.put("2", "22");

        linkedHashMap.forEach((k, v) -> {
            System.out.println("k : " + k + " | v : " + v);
        });

        System.out.println("=======================");
        linkedHashMap.put("3", "33");
        linkedHashMap.forEach((k, v) -> {
            System.out.println("k : " + k + " | v : " + v);
        });

    }
}
