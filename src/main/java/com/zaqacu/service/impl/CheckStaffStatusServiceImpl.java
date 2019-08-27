package com.zaqacu.service.impl;

import com.zaqacu.dao.CheckStaffStatusMapper;
import com.zaqacu.entity.CheckStaffStatus;
import com.zaqacu.service.CheckStaffStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckStaffStatusServiceImpl implements CheckStaffStatusService {

    @Autowired
    private CheckStaffStatusMapper checkStaffStatusMapper;

    @Override
    public boolean addCheckStaffStatusByStaffUid(String staffUid) {
        CheckStaffStatus checkStaffStatus = new CheckStaffStatus();
        checkStaffStatus.setCheckStaffStatusUid(staffUid);
        return checkStaffStatusMapper.insertSelective(checkStaffStatus) != 0 ? true : false;
    }

    @Override
    public boolean removeBatchByStaffUid(List<String> staffUidList) {
        return checkStaffStatusMapper.deleteBatchByStaffUid(staffUidList) != 0 ? true : false;
    }

}
