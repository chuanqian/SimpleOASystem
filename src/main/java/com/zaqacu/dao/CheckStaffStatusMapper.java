package com.zaqacu.dao;

import com.zaqacu.entity.CheckStaffStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckStaffStatusMapper {

    int deleteByPrimaryKey(Integer checkStaffStatusId);

    int deleteBatchByStaffUid(@Param("staffUidList") List<String> staffUidList);

    int insert(CheckStaffStatus record);

    int insertSelective(CheckStaffStatus record);

    CheckStaffStatus selectByPrimaryKey(Integer checkStaffStatusId);

    List<CheckStaffStatus> selectAllCheckStaffStatusBatch(@Param("staffUidList") List<String> staffUidList);

    int updateByPrimaryKeySelective(CheckStaffStatus record);

    int updateByPrimaryKey(CheckStaffStatus record);
}