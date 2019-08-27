package com.zaqacu.service;

import com.zaqacu.entity.UserLogin;

public interface UserLoginService {

    UserLogin getOneUserLoginByUsername(String userName);

}
