package com.zaqacu.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 自定义权限过滤器
 * 实现或
 */
public class OrFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        //获取到当前用户
        Subject subject = getSubject(request, response);
        //获取配置的权限参数
        String[] perms = (String[]) mappedValue;

        for (String perm: perms) {
            System.err.println("MyFilterPerms过滤器设置的权限参数有:"+perm);
        }
        //如果没有设置权限参数，默认成功
        if (perms == null || perms.length == 0) {
        return true;
    }
        for (String perm: perms) {
        System.out.println();
        System.out.println();
        System.out.println("进来"+perm);
        System.out.println();
        System.out.println();
        System.out.println();
        //若当前用户是rolesArray中的任何一个，则有权限访问
        if (subject.hasRole(perm)) {
            System.err.println("当前用户拥有权限："+perm+",允许访问");
            return true;
        }
    }
        return false;
}
}
