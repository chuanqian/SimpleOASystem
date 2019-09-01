package com.zaqacu.dao;

import com.zaqacu.entity.TrainingType;
import com.zaqacu.entity.UserLogin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrainingTypeMapper {

    int deleteByPrimaryKey(Integer trainingTypeId);

    int insert(TrainingType record);

    int insertSelective(TrainingType record);

    TrainingType selectByPrimaryKey(Integer trainingTypeId);

    int updateByPrimaryKeySelective(TrainingType record);

    int updateByPrimaryKey(TrainingType record);





}