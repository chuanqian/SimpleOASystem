package com.zaqacu.dao;

import com.zaqacu.entity.Personnel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonnelMapper {

    int deleteByPrimaryKey(Integer personnelId);

    int deleteBatch(@Param("personnelIds") List<Integer> personnelIds);

    int deleteBatchByStaffUid(@Param("staffUidList") List<String> staffUidList);

    int insert(Personnel record);

    int insertSelective(Personnel record);

    Personnel selectByPrimaryKey(Integer personnelId);

    List<Personnel> selectPersonnelBySql(Personnel personnel);

    int getAllCouunt();

    int updateByPrimaryKeySelective(Personnel record);

    int updateByPrimaryKey(Personnel record);
}