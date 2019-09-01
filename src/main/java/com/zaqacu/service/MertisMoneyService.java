package com.zaqacu.service;

import com.zaqacu.entity.MertisMoney;
import com.zaqacu.entitydto.MertisMoneyDto;

import java.util.HashMap;
import java.util.List;

public interface MertisMoneyService {

    /**
     * 分页获取绩效信息
     * @param mertisMoney 绩效
     * @return
     */
    HashMap<String,Object> getMertisMoneyBySql(MertisMoney mertisMoney);

    /**
     * 修改绩效
     * @param mertisMoneyId 绩效id
     * @param mertisPercentage 绩效百分比
     * @param mertisMoneyNum 绩效金额
     * @return
     */
    boolean editMertisMoneyByMertisId(String mertisMoneyId,String mertisPercentage,String mertisMoneyNum);

    /**
     * 删除绩效
     * @param ids 数组id
     * @return
     */
    boolean removeMertisBatch(String ids);

    /**
     * 新增绩效
     * @param mertisPercentage 百分比
     * @param mertisMoneyNum 金额
     * @return
     */
    boolean addOneMertisMoney(String mertisPercentage,String mertisMoneyNum);

    /**
     * 获取全部绩效信息
     * @return List
     */
    List<MertisMoneyDto> getAllMertisMoney();

    /**
     * 通过id获取绩效信息
     * @param mertisMoneyId 绩效id
     * @return
     */
    double getOneMertisById(int mertisMoneyId);

    /**
     * 获取绩效
     * @param mertisMoneyId 绩效id
     * @return
     */
    MertisMoney getByPrimaryKey(int mertisMoneyId);

}
