package com.zaqacu.service;

import com.zaqacu.entity.Pay;

import java.util.HashMap;

public interface PayService {

    /**
     * 新增薪酬记录
     * @param staffUid 员工编号
     * @param StaffName 员工兴民
     * @param payBasicId 基本拿工资
     * @param payMertisId 绩效工资
     * @param payTime 发放时间
     * @return boolean
     */
    boolean addPay(String staffUid,String StaffName,String payBasicId,String payMertisId,String payTime);

    /**
     * 分页查询薪酬
     * @param pay
     * @return
     */
    HashMap<String,Object> getPayBySql(Pay pay);

    /**
     * 删除记录
     * @param ids id[]
     * @return
     */
    boolean removePayByIds(String ids);

}
