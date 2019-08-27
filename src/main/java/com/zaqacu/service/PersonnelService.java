package com.zaqacu.service;

import com.zaqacu.entity.Personnel;
import com.zaqacu.entitydto.PersonnelDto;

import java.util.HashMap;
import java.util.List;

public interface PersonnelService {
    List<PersonnelDto> getAllStaffAndPosition();

    boolean editPersonnelByPosition(String personnelStaffUid, String sName, String positionName, String personnelNewPositionId, String personnelCause);

    HashMap<String,Object> getAllPersonnelBySql(Personnel personnel);

    boolean removePersonnel(String personnelIds);

    boolean removeBatchByStaffUid(List<String> staffUidList);
}
