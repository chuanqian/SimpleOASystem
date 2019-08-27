package com.zaqacu.service;

import com.zaqacu.entity.StaffPact;

import java.util.HashMap;
import java.util.List;

public interface StaffPactService {
    HashMap<String, Object> getAllPactBySql(StaffPact staffPact);

    boolean editStaffPactById(StaffPact staffPact);

    boolean removeByStaffUid(String staffUid);

    boolean removeBatch(List<String> staffUidList);

    boolean addStaffPact(StaffPact staffPact);
}
