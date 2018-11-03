package com.idea.realize.javacore36.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author happyxu
 * @Description: TODO
 * @Title: MyMethodInterceptor
 * @ProjectName sidea
 * @date 2018/9/16下午8:35
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println("Before: " + method.getName());
        Object result = methodProxy.invokeSuper(obj, args);
        System.out.println("After : " + method.getName());
        return result;
    }
}
