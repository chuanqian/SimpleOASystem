package com.zaqacu.service;

import com.zaqacu.entity.StaffArchives;

import java.util.HashMap;
import java.util.List;

public interface StaffArchivesService {
    /**
     * 分页查询档案信息
     * @param staffArchives 档案
     * @return
     */
    HashMap<String, Object> getAllStaffArchivesBySql(StaffArchives staffArchives);

    /**
     * 修改档案
     * @param staffArchives 档案
     * @return
     */
    boolean editStaffArchives(StaffArchives staffArchives);

    /**
     * 删除档案
     * @param ids id[]
     * @return
     */
    boolean removeStaffArchives(String ids);

    /**
     * 通过员工编号删除档案
     * @param staffUid 员工编号
     * @return
     */
    boolean removeByStaffUid(String staffUid);

    /**
     * 批量删除档案
     * @param staffUidList 员工编号
     * @return
     */
    boolean removeBatch(List<String> staffUidList);

    /**
     * 增加档案
     * @param staffArchives 档案
     * @return
     */
    boolean addStaffArchives(StaffArchives staffArchives);
}
