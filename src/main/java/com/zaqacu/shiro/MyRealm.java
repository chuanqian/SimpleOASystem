package com.zaqacu.shiro;

import com.zaqacu.dao.UserLoginMapper;
import com.zaqacu.entity.UserLogin;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserLoginMapper userLoginMapper;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取用户名
        Object userName =principals.fromRealm(this.getName()).iterator().next();
        System.err.println("给予当前用户"+userName+"授权");
        //查询验证用户拥有的角色
        List<String> listRole = userLoginMapper.selectRoleNames(userName+"");
        for(String s:listRole){
            System.err.println("当前用户拥有的角色有:"+s);
        }
        //创建权限对象
        SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
        auth.addRoles(listRole);
        return auth;
    }
    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取令牌的用户名
        UsernamePasswordToken ut = (UsernamePasswordToken) token;
        Object userName = ut.getPrincipal();
        UserLogin userLogin = userLoginMapper.selectByUserName(userName+"");
        if (userLogin == null) {
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userLogin.getUserName(), userLogin.getUserPassword(), new Md5Hash(userName)
                , this.getName());
        return authenticationInfo;
    }
}