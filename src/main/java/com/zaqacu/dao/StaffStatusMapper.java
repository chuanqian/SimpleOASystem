package com.zaqacu.dao;

import com.zaqacu.entity.StaffStatus;

import java.util.List;

public interface StaffStatusMapper {

    int deleteByPrimaryKey(Integer staffStatusId);

    int insert(StaffStatus record);

    int insertSelective(StaffStatus record);

    StaffStatus selectByPrimaryKey(Integer staffStatusId);

    List<StaffStatus> selectAllStaffStatusBB();

    int updateByPrimaryKeySelective(StaffStatus record);

    int updateByPrimaryKey(StaffStatus record);
}