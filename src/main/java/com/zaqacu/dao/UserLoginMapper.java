package com.zaqacu.dao;

import com.zaqacu.entity.UserLogin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginMapper {

    int deleteByPrimaryKey(Integer userId);

    int deleteBatch(List<String> StaffUidList);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Integer userId);

    /**
     * 通过用户名查询是否存在此用户
     * @param userName
     * @return
     */
    UserLogin selectByUserName(String userName);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);
}