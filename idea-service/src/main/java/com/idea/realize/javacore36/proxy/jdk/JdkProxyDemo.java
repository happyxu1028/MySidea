package com.idea.realize.javacore36.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author happyxu
 * @Description: TODO
 * @Title: JdkProxyDemo
 * @ProjectName sidea
 * @date 2018/9/16下午9:25
 */
public class JdkProxyDemo {

    public static void main(String[] args) {
        PersonInterface personInterface = new PersonInterfaceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(personInterface);
        PersonInterface proxy = (PersonInterface) Proxy.newProxyInstance(PersonInterfaceImpl.class.getClassLoader(), PersonInterfaceImpl.class.getInterfaces(), myInvocationHandler);
        proxy.sayHi();
    }


}

class MyInvocationHandler implements InvocationHandler {


    private PersonInterface personInterface;

    public MyInvocationHandler(PersonInterface personInterface) {
        this.personInterface = personInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK Before: " + method.getName());
        Object result = method.invoke(personInterface, args);
        System.out.println("JDK After : " + method.getName());
        return result;
    }
}
