package com.zaqacu.service;

import com.zaqacu.entity.MertisMoney;
import com.zaqacu.entitydto.MertisMoneyDto;

import java.util.HashMap;
import java.util.List;

public interface MertisMoneyService {

    HashMap<String,Object> getMertisMoneyBySql(MertisMoney mertisMoney);

    boolean editMertisMoneyByMertisId(String mertisMoneyId,String mertisPercentage,String mertisMoneyNum);

    boolean removeMertisBatch(String ids);

    boolean addOneMertisMoney(String mertisPercentage,String mertisMoneyNum);

    List<MertisMoneyDto> getAllMertisMoney();

    double getOneMertisById(int mertisMoneyId);

    MertisMoney getByPrimaryKey(int mertisMoneyId);

}
