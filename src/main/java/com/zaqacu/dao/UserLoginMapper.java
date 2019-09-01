package com.zaqacu.dao;

import com.zaqacu.entity.UserLogin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserLoginMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Integer userId);

    int selectByStaffUid(String staffUid);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);

    int deleteBatch(@Param("staffUidList") List<String> staffUidList);
    /**
     * 通过用户名查询是否存在此用户
     * @param userName
     * @return
     */
    UserLogin selectByUserName(String userName);


    List<UserLogin> selectAllUserLoginBySql(UserLogin userLogin);

    int selectAllCount();

    List<String> selectRoleNames(String userName);
}