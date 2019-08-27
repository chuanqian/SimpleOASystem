package com.zaqacu.service;

import com.zaqacu.entity.StaffArchives;

import java.util.HashMap;
import java.util.List;

public interface StaffArchivesService {
    HashMap<String, Object> getAllStaffArchivesBySql(StaffArchives staffArchives);

    boolean editStaffArchives(StaffArchives staffArchives);

    boolean removeStaffArchives(String ids);

    boolean removeByStaffUid(String staffUid);

    boolean removeBatch(List<String> staffUidList);

    boolean addStaffArchives(StaffArchives staffArchives);
}
