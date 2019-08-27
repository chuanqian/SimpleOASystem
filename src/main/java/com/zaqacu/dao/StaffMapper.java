package com.zaqacu.dao;

import com.zaqacu.entity.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffMapper {

    int deleteByPrimaryKey(String staffUid);

    int deleteBatch(@Param("staffUidList") List<String> staffUidList);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(String staffUid);

    /**
     * 员工分页查询sql
     *
     * @param staff
     * @return
     */
    List<Staff> selectAllStaffBySql(Staff staff);

    /**
     * 查询员工的总条数
     *
     * @return
     */
    int selectCountStaff();

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    List<Staff> selectAllStaffByPersonnel();
}