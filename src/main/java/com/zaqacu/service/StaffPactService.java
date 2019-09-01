package com.zaqacu.service;

import com.zaqacu.entity.StaffPact;

import java.util.HashMap;
import java.util.List;

public interface StaffPactService {
    /**
     * 分页查询合同信息
     * @param staffPact 合同
     * @return
     */
    HashMap<String, Object> getAllPactBySql(StaffPact staffPact);

    /**
     * 修改合同
     * @param staffPact 合同
     * @return
     */
    boolean editStaffPactById(StaffPact staffPact);

    /**
     * 删除合同
     * @param staffUid 员工编号
     * @return
     */
    boolean removeByStaffUid(String staffUid);

    /**
     * 批量删除
     * @param staffUidList 员工编号List
     * @return
     */
    boolean removeBatch(List<String> staffUidList);

    /**
     * 增加合同
     * @param staffPact 合同
     * @return
     */
    boolean addStaffPact(StaffPact staffPact);
}
