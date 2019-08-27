package com.zaqacu.dao;

import com.zaqacu.entity.StaffPact;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffPactMapper {

    int deleteByPrimaryKey(Integer pactId);

    /**
     * 根据员工编号删除合同信息
     * @param staffUid
     * @return
     */
    int deleteByStaffUid(String staffUid);

    int deleteBatch(@Param("staffUidList") List<String> staffUidList);

    int insert(StaffPact record);

    int insertSelective(StaffPact record);

    StaffPact selectByPrimaryKey(Integer pactId);

    /**
     * 分页查询
     * @param staffPact
     * @return
     */
    List<StaffPact> selectAllPactBySql(StaffPact staffPact);

    /**
     *
     * @return
     */
    int selectAllCount();

    int updateByPrimaryKeySelective(StaffPact record);

    int updateByPrimaryKeyWithBLOBs(StaffPact record);

    int updateByPrimaryKey(StaffPact record);
}