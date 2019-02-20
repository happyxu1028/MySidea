package com.idea.realize.javacore36.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author happyxu
 * @Description: TODO
 * @Title: CglibProxyDemo
 * @ProjectName sidea
 * @date 2018/9/16下午8:19
 */
public class CglibProxyDemo {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new MyMethodInterceptor());
        UserServiceImpl userService = (UserServiceImpl) enhancer.create();
        userService.add();
        userService.delete();
    }

}
