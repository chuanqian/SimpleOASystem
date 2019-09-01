package com.zaqacu.service;

import com.zaqacu.entity.UserLogin;

public interface UserLoginService {

    /**
     * 根据账户名查询账户
     * @param userName
     * @return
     */
    UserLogin getOneUserLoginByUsername(String userName);

}
