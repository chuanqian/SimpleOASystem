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

    /**
     * 根据员工编号获取状态
     * @param staffStatusId  id
     * @return
     */
    @Override
    public StaffStatus getOneStaffStatusById(int staffStatusId) {
        return staffStatusMapper.selectByPrimaryKey(staffStatusId);
    }

    /**
     * 获取状态
     * @return
     */
    @Override
    public List<StaffStatus> getAllStaffStatusBB() {
        return staffStatusMapper.selectAllStaffStatusBB();
    }
}
