package com.zaqacu.service.impl;

import com.zaqacu.dao.StaffPactMapper;
import com.zaqacu.entity.StaffPact;
import com.zaqacu.entitydto.StaffPactDto;
import com.zaqacu.service.PositionService;
import com.zaqacu.service.StaffPactService;
import com.zaqacu.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StaffPactServiceImpl implements StaffPactService {

    @Autowired
    private StaffPactMapper staffPactMapper;
    @Autowired
    private PositionService positionService;
    @Autowired
    private StaffService staffService;

    /**
     * 分页查询合同信息
     * @param staffPact 合同
     * @return
     */
    @Override
    public HashMap<String, Object> getAllPactBySql(StaffPact staffPact) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(staffPact.getPage());
        System.out.println(staffPact.getRows());
        System.out.println((staffPact.getPage() - 1) * staffPact.getRows());
        staffPact.setStart((staffPact.getPage() - 1) * staffPact.getRows());
        List<StaffPact> staffPactList = staffPactMapper.selectAllPactBySql(staffPact);
        List<StaffPactDto> staffPactDtos = new ArrayList<>();
        for (int i = 0; i < staffPactList.size(); i++) {
            StaffPactDto staffPactDto = new StaffPactDto();
            staffPactDto.setPactId(staffPactList.get(i).getPactId());
            staffPactDto.setPactCreateTime(staffPactList.get(i).getPactCreateTime());
            staffPactDto.setPactEndTime(staffPactList.get(i).getPactEndTime());
            staffPactDto.setPactInfo(staffPactList.get(i).getPactInfo());
            staffPactDto.setPactNote(staffPactList.get(i).getPactNote());
            staffPactDto.setPosition(positionService.getOnePositionById(staffPactList.get(i).getPactStaffPositionId()));
            staffPactDto.setStaff(staffService.getOneStaffByUid(staffPactList.get(i).getPactStaffUid()));
            staffPactDtos.add(staffPactDto);
        }
        int total = staffPactMapper.selectAllCount();
        map.put("total", total);
        map.put("rows", staffPactDtos);
        return map;
    }

    /**
     * 修改合同
     * @param staffPact 合同
     * @return
     */
    @Override
    public boolean editStaffPactById(StaffPact staffPact) {
        boolean flag = true;
        int index = staffPactMapper.updateByPrimaryKeySelective(staffPact);
        if (index == 0) {
            flag = false;
        }
        return flag;
    }

    /**
     * 输出合同
     * @param staffUid 员工编号
     * @return
     */
    @Override
    public boolean removeByStaffUid(String staffUid) {
        boolean flag = false;
        int index = staffPactMapper.deleteByStaffUid(staffUid);
        if (index != 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 批量删除
     * @param staffUidList 员工编号List
     * @return
     */
    @Override
    public boolean removeBatch(List<String> staffUidList) {
        return staffPactMapper.deleteBatch(staffUidList) == 0 ? false : true;
    }

    /**
     * 增加
     * @param staffPact 合同
     * @return
     */
    @Override
    public boolean addStaffPact(StaffPact staffPact) {
        return staffPactMapper.insertSelective(staffPact) != 1 ? false : true;
    }
}
