package com.zaqacu.service;

import com.zaqacu.entity.Staff;

import java.util.HashMap;
import java.util.List;

public interface StaffService {

    HashMap<String, Object> getAllStaff(Staff staff);

    Staff getOneStaffByUid(String StaffUid);

    boolean removeStaff(String staffIds,String positionNames);

    boolean addStaff(String userName, String userPassword,
                     String staffName, String staffSex, String staffBirth, String staffPhone,
                     String staffEmail, String staffXueli, String staffPosition,
                     String staffInTime, String staffStatusId, String staffNote, String archivesName,
                     String archivesInfo, String archivesNote, String pactCreateTime, String pactEndTime,
                     String pactInfo, String pactNote);

    boolean editStaff(Staff staff);

    List<Staff> getAllStaffByPersonnel(Staff staff);

    List<String> getAllPositionByPositionName(String positionName);

    int getCountStaff();

    List<Staff> getAllStaffByStaffUidList(List<String> staffUidList);

    boolean toGiveEnable(String staffUid,String StaffName,String roleIds);

}
