package com.zaqacu.service;

import com.zaqacu.entity.UserLogin;

public interface UserLoginService {

    /**
     * 根据账户名查询账户
     * @param userName
     * @return
     */
    UserLogin getOneUserLoginByUsername(String userName);

    /**
     * 修改密码
     * @param staffUid
     * @param newPassword
     * @return
     */
    boolean editPassword(String staffUid,String newPassword);

    String queryUserName(String staffUid);

}
