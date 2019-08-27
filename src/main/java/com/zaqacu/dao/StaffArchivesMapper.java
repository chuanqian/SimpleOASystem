package com.zaqacu.dao;

import com.zaqacu.entity.StaffArchives;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffArchivesMapper {

    int deleteByPrimaryKey(Integer archivesId);

    /**
     * 根据员工编号删除档案
     * @param staffUid
     * @return
     */
    int deleteByStaffUid(String staffUid);

    int deleteBatch(@Param("staffUidList") List<String> staffUidList);

    int insert(StaffArchives record);

    int insertSelective(StaffArchives record);

    StaffArchives selectByPrimaryKey(Integer archivesId);

    /**
     * 分页查询档案信息
     * @param archives
     * @return
     */
    List<StaffArchives> selectAllArchivesBySql(StaffArchives archives);

    /**
     * 查询档案总条数
     * @return
     */
    int selectArchivesCount();

    int updateByPrimaryKeySelective(StaffArchives record);

    int updateByPrimaryKeyWithBLOBs(StaffArchives record);

    int updateByPrimaryKey(StaffArchives record);

}