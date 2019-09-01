package com.zaqacu.service;

import com.zaqacu.entity.UserLogin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginAndOutService {
    boolean getOneUserLoginByUserName(String userName);

    boolean addUserLogin(UserLogin userLogin);

    boolean deleteByStaffUidList(List<String> staffUidList);

    int getByStaffUid(String staffUid);

}
