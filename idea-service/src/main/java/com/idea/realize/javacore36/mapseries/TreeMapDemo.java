package com.idea.realize.javacore36.mapseries;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author happyxu
 * @Description: TODO
 * @Title: TreeMapDemo
 * @ProjectName sidea
 * @date 2018/9/19下午9:30
 */
public class TreeMapDemo {

    public static void main(String[] args) {

        Person person1 = new Person("xubin",28);
        Person person2 = new Person("suyu",20);
        Person person3 = new Person("suyu666",230);
//        TreeMap<String,Person> treeMap = new TreeMap(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                String p1 = (String)o1;
//                String p2 = (String)o2;
//                if(p1.length()>p2.length()) {
//                    return 1;
//                }else if(p1.length() < p2.length()){
//                    return -1;
//                }else{
//                    return 0;
//                }
//            }
//        });
//        treeMap.put("3199",person1);
//        treeMap.put("22",person2);
//        treeMap.put("244",person3);
//
//        for (Map.Entry<String,Person> entry : treeMap.entrySet()) {
//            System.out.println("key:"+entry.getKey().toString()+" | value:"+entry.getValue().toString()) ;
//        }


//                TreeMap<String,Person> treeMap = new TreeMap();
//        treeMap.put("3199",person1);
//        treeMap.put("22",person2);
//        treeMap.put("244",person3);
        TreeMap<Person,String> treeMap = new TreeMap();
        treeMap.put(person1,"1");
        treeMap.put(person2,"2");
        treeMap.put(person3,"3");

        for (Map.Entry<Person,String> entry : treeMap.entrySet()) {
            System.out.println("key:"+entry.getKey().toString()+" | value:"+entry.getValue().toString()) ;
        }
    }
}
