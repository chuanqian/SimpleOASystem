package com.zaqacu.service.impl;

import com.zaqacu.constant.CheckTypeConstant;
import com.zaqacu.dao.CheckMapper;
import com.zaqacu.dao.CheckStaffStatusMapper;
import com.zaqacu.dao.CheckTypeMapper;
import com.zaqacu.dao.StaffMapper;
import com.zaqacu.entity.Check;
import com.zaqacu.entity.CheckStaffStatus;
import com.zaqacu.entity.Staff;
import com.zaqacu.entitydto.CheckDto;
import com.zaqacu.entitydto.CheckShowStaffDto;
import com.zaqacu.service.CheckService;
import com.zaqacu.service.CheckStaffStatusService;
import com.zaqacu.util.TimeUtls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private CheckStaffStatusMapper checkStaffStatusMapper;
    @Autowired
    private CheckStaffStatusService checkStaffStatusService;
    @Autowired
    private CheckMapper checkMapper;
    @Autowired
    private CheckTypeMapper checkTypeMapper;

    /**
     * 分页查询考勤员工信息
     * @param staff 员工
     * @return
     */
    @Override
    public HashMap<String, Object> showCheckStaff(Staff staff) {
        HashMap<String, Object> map = new HashMap<>();
        List<CheckShowStaffDto> checkShowStaffDtos = new ArrayList<>();
        int total=0;
        staff.setStart((staff.getPage() - 1) * staff.getRows());
        List<Staff> staffList = staffMapper.selectAllStaffBySql(staff);
        if(staffList.size()>0){
            List<String> staffUidList = new ArrayList<>();
            for (Staff staff1 : staffList) {
                staffUidList.add(staff1.getStaffUid());
            }
            List<CheckStaffStatus> checkStaffStatuses = checkStaffStatusMapper.selectAllCheckStaffStatusBatch(staffUidList);
            for (int i = 0; i < staffList.size(); i++) {
                CheckShowStaffDto checkShowStaffDto = new CheckShowStaffDto();
                checkShowStaffDto.setStaff(staffList.get(i));
                checkShowStaffDto.setCheckStaffStatus(checkStaffStatusMapper.selectOneCheckStatus(staffList.get(i).getStaffUid()));
                checkShowStaffDtos.add(checkShowStaffDto);
            }
            total = staffMapper.selectCountStaff();
        }
        map.put("total", total);
        map.put("rows", checkShowStaffDtos);
        return map;
    }

    /**
     * 修改考勤
     * @param beiStaffUid 被考勤员工编号
     * @param staffName 员工姓名
     * @param checkTypeId
     * @param checkTypeMoney 考勤类型金额
     * @param staffUid 考勤人员工编号
     * @return
     */
    @Override
    public boolean editCheckStaffStatusAndCheck(String beiStaffUid, String staffName, String checkTypeId, String checkTypeMoney, String staffUid) {
        System.out.println(beiStaffUid);
        System.out.println(checkStaffStatusMapper.selectByStaffUid(beiStaffUid));
        if (CheckTypeConstant.ALREADYCHECK.equals(checkStaffStatusMapper.selectByStaffUid(beiStaffUid))) {
            System.out.println("fdfgfdgdfgsdfgfd");
            return false;
        }
        System.out.println("今天");
        boolean b1 = checkStaffStatusService.editByStaffUidAndStatusName(beiStaffUid, CheckTypeConstant.ALREADYCHECK);
        System.out.println(b1);
        Check check = new Check();
        check.setCheckBeiStaffUid(beiStaffUid);
        check.setCheckMoney(Double.parseDouble(checkTypeMoney));
        check.setCheckTime(TimeUtls.getTimeFommat(new Date()));
        check.setCheckStaffUid(staffUid);
        check.setCheckTypeId(Integer.parseInt(checkTypeId));
        boolean b2 = checkMapper.insertSelective(check) != 0 ? true : false;
        System.out.println(b2);
        return b1 && b2;
    }

    /**
     * 获取考勤记录
     * @param check 考勤
     * @return
     */
    @Override
    public HashMap<String, Object> showCheckRecord(Check check) {
        HashMap<String,Object> map=new HashMap<>();
        check.setStart((check.getPage() - 1) * check.getRows());
        List<Check> checks = checkMapper.selectAllCheckBySql(check);
        List<CheckDto> checkDtos = new ArrayList<>();
        for (Check check1 : checks) {
            CheckDto checkDto=new CheckDto();
            checkDto.setCheckId(check1.getCheckId());
            checkDto.setCheckTime(check1.getCheckTime());
            checkDto.setStaffBei(staffMapper.selectByPrimaryKey(check1.getCheckBeiStaffUid()));
            checkDto.setStaff(staffMapper.selectByPrimaryKey(check1.getCheckStaffUid()));
            checkDto.setCheckMoney(check1.getCheckMoney());
            checkDto.setCheckType(checkTypeMapper.selectByPrimaryKey(check1.getCheckTypeId()));
            checkDtos.add(checkDto);
        }
        int total = checkMapper.selectAllCount();
        map.put("total",total);
        map.put("rows",checkDtos);
        return map;
    }

    /**
     * 删除
     * @param id 考勤编号数组
     * @return
     */
    @Override
    public boolean removeCheckRecord(String id) {
        String[] ids=id.split(",");
        List<Integer> checkIds=new ArrayList<>();
        for (String s : ids) {
            checkIds.add(Integer.parseInt(s));
        }
        return checkMapper.deleteCheckRecordBatch(checkIds)!=0?true:false;
    }

    /**
     * 计算薪酬
     * @param staffUid 员工编号id
     * @param firstDay 这个月的第一天
     * @param exitsDay 当前结算时间
     * @return
     */
    @Override
    public List<Double> getAllCheckByStaffUidAndDate(String staffUid, Date firstDay, Date exitsDay) {
        return checkMapper.selectAllCheckByStaffUidAndDate(staffUid,firstDay,exitsDay);
    }
}
