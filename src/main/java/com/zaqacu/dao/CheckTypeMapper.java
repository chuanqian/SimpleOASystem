package com.zaqacu.dao;

import com.zaqacu.entity.CheckType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckTypeMapper {

    int deleteByPrimaryKey(Integer checkTypeId);

    int deleteByCheckTypes(@Param("checkTypeList") List<Integer> checkTypeList);

    int insert(CheckType record);

    int insertSelective(CheckType record);

    int insertCheckType(CheckType checkType);

    CheckType selectByPrimaryKey(Integer checkTypeId);

    List<CheckType> selectAllCheckTypeBySql(CheckType checkType);

    List<CheckType> selectAllCheckType();

    int selectAllCount();

    int updateByPrimaryKeySelective(CheckType record);

    int updateByPrimaryKey(CheckType record);


}