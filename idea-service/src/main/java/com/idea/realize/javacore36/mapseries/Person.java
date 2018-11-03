package com.idea.realize.javacore36.mapseries;

import com.alibaba.fastjson.JSON;

import java.util.Comparator;

/**
 * @author happyxu
 * @Description: TODO
 * @Title: Person
 * @ProjectName sidea
 * @date 2018/9/19下午9:32
 */
public class Person implements Comparator,Comparable{

    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = (Person)o1;
        Person p2 = (Person)o2;
        if(p1.age>p2.age) {
            return 1;
        }else if(p1.age < p2.age){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public int compareTo(Object o) {
        Person p2 = (Person)o;
        if(this.age>p2.age) {
            return 1;
        }else if(this.age < p2.age){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
