package com.idea.realize;

import com.idea.realize.interfaces.UserFacade;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

//    @Bean
//    public BeanNameAutoProxyCreator setBeanNameAutoProxyCreator(){
//        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
//        beanNameAutoProxyCreator.setBeanNames("userController");
//
//        beanNameAutoProxyCreator.setInterceptorNames("springMethodInterceptor");
////        beanNameAutoProxyCreator.set
//        return beanNameAutoProxyCreator;
//    }


    @Bean
    public ProxyFactoryBean setProxyFactoryBean() throws ClassNotFoundException {
        int a[] = new int[]{1};
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setInterceptorNames("springMethodInterceptor");
        proxyFactoryBean.setTargetName("userFacade");
//        proxyFactoryBean.setTargetClass(UserFacade.class);
        proxyFactoryBean.setProxyInterfaces(new Class[]{UserFacade.class});
        return proxyFactoryBean;
    }


}
