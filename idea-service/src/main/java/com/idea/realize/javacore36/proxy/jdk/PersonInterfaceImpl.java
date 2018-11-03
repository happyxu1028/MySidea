package com.idea.realize.javacore36.proxy.jdk;

/**
 * @author happyxu
 * @Description: TODO
 * @Title: PersonInterfaceImpl
 * @ProjectName sidea
 * @date 2018/9/16下午9:26
 */
public class PersonInterfaceImpl implements PersonInterface{

    @Override
    public void sayHi() {
        System.out.println("Person say Hi");
    }
}
