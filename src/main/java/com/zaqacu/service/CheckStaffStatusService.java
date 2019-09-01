package com.zaqacu.service;

import java.util.List;

public interface CheckStaffStatusService {
    /**
     * 增加考勤类型
     * @param staffUid
     * @return
     */
    boolean addCheckStaffStatusByStaffUid(String staffUid);

    /**
     * 删除考勤类型
     * @param staffUidList
     * @return
     */
    boolean removeBatchByStaffUid(List<String> staffUidList);

    /**
     * 修改考勤状态
     * @param staffUid 员工编号
     * @param checkStaffStatusName 状态名称
     * @return
     */
    boolean editByStaffUidAndStatusName(String staffUid,String checkStaffStatusName);

    /**
     * 获取员工
     * @param staffUid
     * @return
     */
    String getByStaffUid(String staffUid);

    /**
     * 修改员工考勤状态
     * @param checkStaffStatusName
     * @return
     */
    int editStatusNameByTimes(String checkStaffStatusName);
}
