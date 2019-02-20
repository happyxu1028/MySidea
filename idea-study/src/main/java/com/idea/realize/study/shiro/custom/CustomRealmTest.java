package com.idea.realize.study.shiro.custom;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;

public class CustomRealmTest {


    public static void main(String[] args) {
        CustomRealm customRealm = new CustomRealm();

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(customRealm);

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        AuthenticationToken token = new UsernamePasswordToken("linshu", "1234");
        subject.login(token);


        System.out.println(subject.isAuthenticated());
        subject.checkRole("admin");
        subject.checkPermission("user:add");
        subject.checkPermission("user:edit");
    }
}
