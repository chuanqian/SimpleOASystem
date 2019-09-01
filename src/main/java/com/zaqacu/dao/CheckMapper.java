package com.zaqacu.dao;

import com.zaqacu.entity.Check;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CheckMapper {

    int deleteByPrimaryKey(Integer checkId);

    int deleteCheckRecordBatch(@Param("checkIdList") List<Integer> checkIdList);

    int insert(Check record);

    int insertSelective(Check record);

    Check selectByPrimaryKey(Integer checkId);

    List<Check> selectAllCheckBySql(Check check);

    List<Double> selectAllCheckByStaffUidAndDate(@Param("staffUid") String staffUid,@Param("firstDay") Date firstDay,@Param("exitsDay") Date Exitsday);

    int selectAllCount();

    int updateByPrimaryKeySelective(Check record);

    int updateByPrimaryKey(Check record);
}