package com.zaqacu.service.impl;

import com.zaqacu.dao.UserLoginMapper;
import com.zaqacu.entity.UserLogin;
import com.zaqacu.service.UserLoginService;
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
}
