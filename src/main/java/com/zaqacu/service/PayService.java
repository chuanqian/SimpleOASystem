package com.zaqacu.service;

import com.zaqacu.entity.Pay;

import java.util.HashMap;

public interface PayService {

    boolean addPay(String staffUid,String StaffName,String payBasicId,String payMertisId,String payTime);

    HashMap<String,Object> getPayBySql(Pay pay);

    boolean removePayByIds(String ids);

}
