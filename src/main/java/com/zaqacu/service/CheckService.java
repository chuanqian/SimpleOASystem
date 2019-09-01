package com.zaqacu.service;

import com.zaqacu.entity.Check;
import com.zaqacu.entity.Staff;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface CheckService {

    /**
     * 分页显示考勤员工的信息
     * @param staff
     * @return
     */
    HashMap<String,Object> showCheckStaff(Staff staff);

    /**
     * 添加员工考勤记录
     * @param beiStaffUid 被考勤员工编号
     * @param staffName 员工姓名
     * @param checkStaffStatusId 考勤类型编号
     * @param checkTypeMoney 考勤类型金额
     * @param staffUid 考勤人员工编号
     * @return
     */
    boolean editCheckStaffStatusAndCheck(String beiStaffUid, String staffName, String checkStaffStatusId, String checkTypeMoney, String staffUid);

    /**
     * 分页查询考勤记录
     * @param check 考勤
     * @return
     */
    HashMap<String,Object> showCheckRecord(Check check);

    /**
     * 删除考勤记录
     * @param id 考勤编号数组
     * @return
     */
    boolean removeCheckRecord(String id);

    /**
     * 计算薪酬函数
     * @param staffUid 员工编号id
     * @param firstDay 这个月的第一天
     * @param exitsDay 当前结算时间
     * @return
     */
    List<Double> getAllCheckByStaffUidAndDate(String staffUid, Date firstDay, Date exitsDay);
}
