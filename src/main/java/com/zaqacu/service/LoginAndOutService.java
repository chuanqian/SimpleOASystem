package com.zaqacu.service;

import com.zaqacu.entity.UserLogin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginAndOutService {
    /**
     * 查询账户
     * @param userName 账户名
     * @return
     */
    boolean getOneUserLoginByUserName(String userName);

    /**
     * 增加账户
     * @param userLogin 账户
     * @return
     */
    boolean addUserLogin(UserLogin userLogin);

    /**
     * 删除账户
     * @param staffUidList
     * @return
     */
    boolean deleteByStaffUidList(List<String> staffUidList);

    /**
     * 通过员工id获取
     * @param staffUid 员工编号
     * @return
     */
    int getByStaffUid(String staffUid);

}
