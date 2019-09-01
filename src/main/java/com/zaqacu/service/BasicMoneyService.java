package com.zaqacu.service;

import com.zaqacu.entity.BasicMoney;

import java.util.HashMap;
import java.util.List;

public interface BasicMoneyService {

    /**
     * 分页获取基本工资信息
     * @param basicMoney
     * @return
     */
    HashMap<String,Object> getAllBasicMoneyBySql(BasicMoney basicMoney);

    /**
     * 修改基本工资金额
     * @param basicMoney 金额
     * @return
     */
    boolean editByPrimaryKeySelective(BasicMoney basicMoney);

    /**
     * 删除基本工资信息
     * @param ids id数组
     * @return
     */
    boolean removeBasicMoneyBatch(String ids);

    /**
     * 增加基本工资
     * @param record
     * @return boolean
     */
    boolean addSelective(BasicMoney record);

    /**
     * 获取全部基本工资信息
     * @return
     */
    List<BasicMoney> getAllBasicMoney();

    /**
     * 通过id获取基本工资金额
     * @param basicMoneyId
     * @return
     */
    double getOneBasicMoneyById(int basicMoneyId);

    /**
     * 通过主键查询基本工资信息
     * @param basicMoneyId
     * @return
     */
    BasicMoney getByPrimaryKey(int basicMoneyId);


}
