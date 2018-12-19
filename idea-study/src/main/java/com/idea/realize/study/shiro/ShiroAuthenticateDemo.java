package com.idea.realize.study.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class ShiroAuthenticateDemo {



    SimpleAccountRealm realm = new SimpleAccountRealm();

    @Before
    public void init(){
        realm.addAccount("linshu","1234");
    }

    @Test
    public void testShiro(){
        //创建SecurityManage环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        defaultSecurityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //获取主体
        Subject subject = SecurityUtils.getSubject();


        AuthenticationToken token = new UsernamePasswordToken("linshu","1234");
        //主体提交认证请求
        subject.login(token);

        System.out.println(subject.isAuthenticated());

    }

}
