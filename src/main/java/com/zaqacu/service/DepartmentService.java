package com.zaqacu.service;

import com.zaqacu.entity.Department;

import java.util.HashMap;
import java.util.List;

public interface DepartmentService {
    /**
     * 分页获取部门信息
     * @param department 部门
     * @return
     */
    HashMap<String, Object> getAllDepartment(Department department);

    /**
     * 增加部门
     * @param department 部门
     * @return
     */
    int addSelectiveDepartment(Department department);

    /**
     * 修改部门信息
     * @param department 部门信息
     * @return
     */
    int editByPrimaryKeySelective(Department department);

    /**
     * 删除部门
     * @param removeId 部门id
     * @return
     */
    boolean removeByPrimaryKeySelective(String removeId);

    /**
     * 批量删除部门
     * @param removeId 部门编号IDs
     * @return
     */
    boolean removeBatch(String removeId);

    /**
     * 通过部门id获取部门信息
     * @param departmentId
     * @return
     */
    Department getOneDepartmentById(int departmentId);

    /**
     * 获取全部部门信息BB
     * @return
     */
    List<Department> getAllDepartmentBB();

    /**
     * 获取全部部门信息AA
     * @return
     */
    List<Department> getAllDepartmentAA();
}
