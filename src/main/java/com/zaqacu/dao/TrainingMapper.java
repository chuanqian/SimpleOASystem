package com.zaqacu.dao;

import com.zaqacu.entity.Training;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrainingMapper {

    int deleteByPrimaryKey(Integer trainingId);

    /**
     * 根据员工编号删除培训记录
     * @param staffUid
     * @return
     */
    int deleteByStaffUid(String staffUid);

    int deleteBatch(@Param("staffUidList") List<String> staffUidList);

    int insert(Training record);

    int insertSelective(Training record);

    Training selectByPrimaryKey(Integer trainingId);

    Training selectByStaffUid(String staffUid);

    List<Training> selectByStaffUidList(@Param("staffUidList") List<String> staffUidList);

    int updateByPrimaryKeySelective(Training record);

    int updateByPrimaryKey(Training record);
}