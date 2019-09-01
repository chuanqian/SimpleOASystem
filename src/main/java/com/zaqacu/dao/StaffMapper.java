package com.zaqacu.dao;

import com.zaqacu.entity.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffMapper {

    int deleteByPrimaryKey(String staffUid);

    /**
     * 批量删除员工
     * @param staffUidList
     * @return
     */
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

    List<String> selectAllPositionByPositionName(String positionName);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    /**
     * 人事调动分页查询全部员工
     * @param staff
     * @return
     */
    List<Staff> selectAllStaffByPersonnel(Staff staff);

    List<Staff> selectAllStaffByStaffUidList(@Param("staffUidList") List<String> staffUidList);


}