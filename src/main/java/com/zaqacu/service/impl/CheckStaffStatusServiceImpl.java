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

    /**
     * 增加考勤状态
     * @param staffUid 员工编号
     * @return
     */
    @Override
    public boolean addCheckStaffStatusByStaffUid(String staffUid) {
        CheckStaffStatus checkStaffStatus = new CheckStaffStatus();
        checkStaffStatus.setCheckStaffStatusUid(staffUid);
        return checkStaffStatusMapper.insertSelective(checkStaffStatus) != 0 ? true : false;
    }

    /**
     * 删除
     * @param staffUidList
     * @return
     */
    @Override
    public boolean removeBatchByStaffUid(List<String> staffUidList) {
        return checkStaffStatusMapper.deleteBatchByStaffUid(staffUidList) != 0 ? true : false;
    }

    /**
     * 修改
     * @param staffUid 员工编号
     * @param checkStaffStatusName 状态名称
     * @return
     */
    @Override
    public boolean editByStaffUidAndStatusName(String staffUid, String checkStaffStatusName) {

        CheckStaffStatus checkStaffStatus = new CheckStaffStatus();
        checkStaffStatus.setCheckStaffStatusUid(staffUid);
        checkStaffStatus.setCheckStaffStatusName(checkStaffStatusName);
        return checkStaffStatusMapper.updateByStaffUidAndStatusName(checkStaffStatus) != 0 ? true : false;

    }

    /**
     * 获取员工名
     * @param staffUid
     * @return
     */
    @Override
    public String getByStaffUid(String staffUid) {
        return checkStaffStatusMapper.selectByStaffUid(staffUid);
    }

    /**
     * 定时改变状态
     * @param checkStaffStatusName
     * @return
     */
    @Override
    public int editStatusNameByTimes(String checkStaffStatusName) {
        return checkStaffStatusMapper.updateStatusNameByTimes(checkStaffStatusName);
    }

}
