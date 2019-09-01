package com.zaqacu.dao;

import com.zaqacu.entity.MertisMoney;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MertisMoneyMapper {

    int deleteByPrimaryKey(Integer mertisMoneyId);

    int deleteByMertisIdsBatch(@Param("mertisMoneyIds") List<Integer> mertisMoneyIds);

    int insert(MertisMoney record);

    int insertSelective(MertisMoney record);

    MertisMoney selectByPrimaryKey(Integer mertisMoneyId);

    List<MertisMoney> selectMertisMoneyBySql(MertisMoney mertisMoney);

    List<MertisMoney> selectAllMertisMoney();

    double selectOneMertisById(int mertisMoneyId);

    int selectMertisMoneyCount();

    int updateByPrimaryKeySelective(MertisMoney record);

    int updateByPrimaryKey(MertisMoney record);

}