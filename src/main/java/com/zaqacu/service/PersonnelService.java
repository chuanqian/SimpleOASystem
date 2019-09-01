package com.zaqacu.service;

import com.zaqacu.entity.Personnel;
import com.zaqacu.entity.Staff;

import java.util.HashMap;
import java.util.List;

public interface PersonnelService {
    HashMap<String,Object> getAllStaffAndPosition(Staff staff);

    boolean editPersonnelByPosition(String personnelStaffUid, String sName, String positionName, String personnelNewPositionId, String personnelCause);

    HashMap<String,Object> getAllPersonnelBySql(Personnel personnel);

    boolean removePersonnel(String personnelIds);

    boolean removeBatchByStaffUid(List<String> staffUidList);
}
