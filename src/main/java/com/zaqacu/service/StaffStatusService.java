package com.zaqacu.service;

import com.zaqacu.entity.StaffStatus;

import java.util.List;

public interface StaffStatusService {

    /**
     * 获取员工状态
     * @param staffStatusId  id
     * @return
     */
    StaffStatus getOneStaffStatusById(int staffStatusId);

    /**
     * 获取全部员工状态
     * @return
     */
    List<StaffStatus> getAllStaffStatusBB();

}
