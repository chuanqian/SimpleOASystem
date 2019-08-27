package com.zaqacu.service.impl;

import com.zaqacu.dao.StaffStatusMapper;
import com.zaqacu.entity.StaffStatus;
import com.zaqacu.service.StaffStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffStatusServiceImpl implements StaffStatusService {
    @Autowired
    private StaffStatusMapper staffStatusMapper;
    @Override
    public StaffStatus getOneStaffStatusById(int staffStatusId) {
        return staffStatusMapper.selectByPrimaryKey(staffStatusId);
    }

    @Override
    public List<StaffStatus> getAllStaffStatusBB() {
        return staffStatusMapper.selectAllStaffStatusBB();
    }
}
