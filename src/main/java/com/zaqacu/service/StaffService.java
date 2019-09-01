package com.zaqacu.service;

import com.zaqacu.entity.Staff;

import java.util.HashMap;
import java.util.List;

public interface StaffService {

    /**
     * 分页查询员工
     * @param staff 员工
     * @return
     */
    HashMap<String, Object> getAllStaff(Staff staff);

    /**
     * 通过主键查询员工
     * @param StaffUid 员工编号
     * @return
     */
    Staff getOneStaffByUid(String StaffUid);

    /**
     * 删除员工
     * @param staffIds 员工编号
     * @param positionNames 职位名称
     * @return
     */
    boolean removeStaff(String staffIds,String positionNames);

    /**
     * 增加员工
     * @param userName
     * @param userPassword
     * @param staffName
     * @param staffSex
     * @param staffBirth
     * @param staffPhone
     * @param staffEmail
     * @param staffXueli
     * @param staffPosition
     * @param staffInTime
     * @param staffStatusId
     * @param staffNote
     * @param archivesName
     * @param archivesInfo
     * @param archivesNote
     * @param pactCreateTime
     * @param pactEndTime
     * @param pactInfo
     * @param pactNote
     * @return
     */
    boolean addStaff(String userName, String userPassword,
                     String staffName, String staffSex, String staffBirth, String staffPhone,
                     String staffEmail, String staffXueli, String staffPosition,
                     String staffInTime, String staffStatusId, String staffNote, String archivesName,
                     String archivesInfo, String archivesNote, String pactCreateTime, String pactEndTime,
                     String pactInfo, String pactNote);

    /**
     * 修改员工
     * @param staff 员工
     * @return
     */
    boolean editStaff(Staff staff);

    /**
     * 人事查询员工
     * @param staff
     * @return
     */
    List<Staff> getAllStaffByPersonnel(Staff staff);

    /**
     * 职位名称查询员工
     * @param positionName 职位名称
     * @return
     */
    List<String> getAllPositionByPositionName(String positionName);

    /**
     * 查询总条数
     * @return
     */
    int getCountStaff();

    /**
     * 通过编号查询全部员工信息
     * @param staffUidList 员工编号ids
     * @return
     */
    List<Staff> getAllStaffByStaffUidList(List<String> staffUidList);

    /**
     * 授权
     * @param staffUid 员工编号
     * @param StaffName 员工信息
     * @param roleIds 角色编号
     * @return
     */
    boolean toGiveEnable(String staffUid,String StaffName,String roleIds);

}
