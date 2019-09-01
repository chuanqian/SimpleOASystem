package com.zaqacu.service;

import com.zaqacu.entity.Department;

import java.util.HashMap;
import java.util.List;

public interface DepartmentService {
    HashMap<String, Object> getAllDepartment(Department department);

    int addSelectiveDepartment(Department department);

    int editByPrimaryKeySelective(Department department);

    boolean removeByPrimaryKeySelective(String removeId);

    boolean removeBatch(String removeId);

    Department getOneDepartmentById(int departmentId);

    List<Department> getAllDepartmentBB();

    List<Department> getAllDepartmentAA();
}
