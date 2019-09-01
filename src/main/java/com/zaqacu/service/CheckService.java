package com.zaqacu.service;

import com.zaqacu.entity.Check;
import com.zaqacu.entity.Staff;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface CheckService {

    HashMap<String,Object> showCheckStaff(Staff staff);

    boolean editCheckStaffStatusAndCheck(String beiStaffUid, String staffName, String checkStaffStatusId, String checkTypeMoney, String staffUid);

    HashMap<String,Object> showCheckRecord(Check check);

    boolean removeCheckRecord(String id);

    List<Double> getAllCheckByStaffUidAndDate(String staffUid, Date firstDay, Date exitsDay);
}
