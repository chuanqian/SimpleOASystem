package com.zaqacu.service.impl;

import com.zaqacu.dao.CheckStaffStatusMapper;
import com.zaqacu.dao.StaffMapper;
import com.zaqacu.entity.CheckStaffStatus;
import com.zaqacu.entity.Staff;
import com.zaqacu.entitydto.CheckShowStaffDto;
import com.zaqacu.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private CheckStaffStatusMapper checkStaffStatusMapper;

    @Override
    public HashMap<String, Object> showCheckStaff(Staff staff) {
        HashMap<String, Object> map = new HashMap<>();
        staff.setStart((staff.getPage() - 1) * staff.getRows());
        List<Staff> staffList = staffMapper.selectAllStaffBySql(staff);
        List<String> staffUidList=new ArrayList<>();
        for (Staff staff1 : staffList) {
            staffUidList.add(staff1.getStaffUid());
        }
        List<CheckStaffStatus> checkStaffStatuses = checkStaffStatusMapper.selectAllCheckStaffStatusBatch(staffUidList);
        List<CheckShowStaffDto> checkShowStaffDtos=new ArrayList<>();
        for(int i=0;i<staffList.size();i++){
            CheckShowStaffDto checkShowStaffDto=new CheckShowStaffDto();
            checkShowStaffDto.setStaff(staffList.get(i));
            checkShowStaffDto.setCheckStaffStatus(checkStaffStatuses.get(i));
            checkShowStaffDtos.add(checkShowStaffDto);
        }
        int total=staffMapper.selectCountStaff();
        map.put("total",total);
        map.put("rows",checkShowStaffDtos);
        return map;
    }
}
