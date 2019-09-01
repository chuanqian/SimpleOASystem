package com.zaqacu.service;

import com.zaqacu.entity.Personnel;
import com.zaqacu.entity.Staff;

import java.util.HashMap;
import java.util.List;

public interface PersonnelService {
    /**
     * 获取人事调动员工信息
     * @param staff 员工
     * @return
     */
    HashMap<String,Object> getAllStaffAndPosition(Staff staff);

    /**
     * 修改员工
     * @param personnelStaffUid 调动员工编号
     * @param sName 名称
     * @param positionName 职位
     * @param personnelNewPositionId 新职位id
     * @param personnelCause 原因
     * @return
     */
    boolean editPersonnelByPosition(String personnelStaffUid, String sName, String positionName, String personnelNewPositionId, String personnelCause);

    /**
     * 获取人事调动记录
     * @param personnel 人事
     * @return
     */
    HashMap<String,Object> getAllPersonnelBySql(Personnel personnel);

    /**
     * 删除人事调动信息
     * @param personnelIds 人事记录编号数组
     * @return
     */
    boolean removePersonnel(String personnelIds);

    /**
     * 通过员工编号删除记录
     * @param staffUidList 员工编号
     * @return
     */
    boolean removeBatchByStaffUid(List<String> staffUidList);
}
