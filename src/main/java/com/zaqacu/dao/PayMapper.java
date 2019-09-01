package com.zaqacu.dao;

import com.zaqacu.entity.Pay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayMapper {

    int deleteByPrimaryKey(Integer payId);

    int deleteByPayIds(@Param("payIds") List<Integer> payIds);

    int insert(Pay record);

    int insertSelective(Pay record);

    Pay selectByPrimaryKey(Integer payId);

    List<Pay> selectPayBySql(Pay pay);

    int selectAllPayCount();

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);


}