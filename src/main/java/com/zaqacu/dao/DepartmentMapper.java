package com.zaqacu.dao;

import com.zaqacu.entity.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {

    int deleteByPrimaryKey(Integer departmentId);

    int deleteBatch(@Param("departmentId") List<Integer> departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departmentId);

    /**
     * 查询全部部门信息
     *
     * @return
     */
    List<Department> selectAllDepartment(Department department);

    /**
     * 查询总条数
     * @return
     */
    int selectAllCountBySql();

    /**
     * 查询全部部门信息
     * @return
     */
    List<Department> selectAllDepartmentBB();

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}