package com.zaqacu.service.impl;

import com.zaqacu.dao.UserLoginMapper;
import com.zaqacu.entity.UserLogin;
import com.zaqacu.service.UserLoginService;
import com.zaqacu.util.SaltUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    /**
     * 查询账户
     * @param userName
     * @return
     */
    @Override
    public UserLogin getOneUserLoginByUsername(String userName) {
        return userLoginMapper.selectByUserName(userName);
    }

    @Override
    public boolean editPassword(String staffUid, String newPassword) {
        UserLogin userLogin=new UserLogin();
        userLogin.setStaffUid(staffUid);
        String saltPassword = SaltUtils.getSaltPassword(newPassword, this.queryUserName(staffUid));
        userLogin.setUserPassword(saltPassword);
        return userLoginMapper.updatePassword(userLogin)!=1?false:true;
    }

    @Override
    public String queryUserName(String staffUid) {
        return userLoginMapper.queryUserName(staffUid);
    }
}
