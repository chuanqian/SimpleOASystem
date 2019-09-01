package com.zaqacu.dao;

import com.zaqacu.entity.BasicMoney;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasicMoneyMapper {

    int deleteByPrimaryKey(Integer basicMoneyId);

    int deleteBasicMoneyBatch(@Param("basicMoneyIds") List<Integer> basicMoneyIds);

    int insert(BasicMoney record);

    int insertSelective(BasicMoney record);

    BasicMoney selectByPrimaryKey(Integer basicMoneyId);

    List<BasicMoney> selectAllBasicMoneyBySql(BasicMoney basicMoney);

    List<BasicMoney> selectAllBasicMoney();

    double selectOneBasicMoneyById(int basicMoneyId);

    int selectAllBasicCount();

    int updateByPrimaryKeySelective(BasicMoney record);

    int updateByPrimaryKey(BasicMoney record);
}