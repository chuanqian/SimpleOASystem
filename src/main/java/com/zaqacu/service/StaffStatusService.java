package com.zaqacu.service;

import com.zaqacu.entity.StaffStatus;

import java.util.List;

public interface StaffStatusService {

    StaffStatus getOneStaffStatusById(int staffStatusId);

    List<StaffStatus> getAllStaffStatusBB();

}
