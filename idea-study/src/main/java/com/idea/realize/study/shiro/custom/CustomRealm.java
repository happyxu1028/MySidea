package com.idea.realize.study.shiro.custom;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    /**
     * 模拟数据库
     */
    Map<String, String> userMap = new HashMap<String, String>(12);

    {
        userMap.put("linshu", "1234");
    }

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        Set<String> rolesSet = getRolesByUsername(username);
        Set<String> permissionSet = getPermissionByUsername(username);

        AuthorizationInfo result = new SimpleAuthorizationInfo();
        ((SimpleAuthorizationInfo) result).setRoles(rolesSet);
        ((SimpleAuthorizationInfo) result).setStringPermissions(permissionSet);
        return result;
    }

    /**
     * 模拟获取角色数据
     *
     * @param username
     * @return
     */
    private Set<String> getRolesByUsername(String username) {
        Set<String> set = new HashSet<String>();
        set.add("admin");
        set.add("user");
        return set;
    }

    /**
     * 模拟获取权限数据
     *
     * @param username
     * @return
     */
    private Set<String> getPermissionByUsername(String username) {
        Set<String> set = new HashSet<String>();
        set.add("user:add");
        set.add("user:edit");
        return set;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = getPassWordByName(username);

        if (password == null) {
            return null;
        }

        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                "linshu", password, "CustomRealm");

        return authenticationInfo;
    }

    private String getPassWordByName(String userName) {
        return userMap.get(userName);
    }
}
