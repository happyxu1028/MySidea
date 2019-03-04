package com.idea.realize.study.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class ShiroAuthentionDemo {

    SimpleAccountRealm realm = new SimpleAccountRealm();


    @Before
    public void init() {
        realm.addAccount("linshu", "1234", "admin");
    }

    @Test
    public void testShiro() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);


        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        AuthenticationToken authToken = new UsernamePasswordToken("linshu", "1234");
        subject.login(authToken);

        System.out.println("是否认证:   " + subject.isAuthenticated());

        subject.checkRole("admin");
//        System.out.println("是否admin授权:  "+subject.checkPermission("admin"););
    }
}

