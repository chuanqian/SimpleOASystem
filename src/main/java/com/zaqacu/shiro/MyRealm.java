package com.zaqacu.shiro;

import com.zaqacu.dao.UserLoginMapper;
import com.zaqacu.entity.UserLogin;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

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
        return null;
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
