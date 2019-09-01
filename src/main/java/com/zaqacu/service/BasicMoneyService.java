package com.zaqacu.service;

import com.zaqacu.entity.BasicMoney;

import java.util.HashMap;
import java.util.List;

public interface BasicMoneyService {

    HashMap<String,Object> getAllBasicMoneyBySql(BasicMoney basicMoney);

    boolean editByPrimaryKeySelective(BasicMoney basicMoney);

    boolean removeBasicMoneyBatch(String ids);

    boolean addSelective(BasicMoney record);

    List<BasicMoney> getAllBasicMoney();

    double getOneBasicMoneyById(int basicMoneyId);

    BasicMoney getByPrimaryKey(int basicMoneyId);


}
