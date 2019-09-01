package com.zaqacu.service.impl;

import com.zaqacu.dao.DepartmentMapper;
import com.zaqacu.entity.Department;
import com.zaqacu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 获取全部部门信息
     *
     * @return
     */
    @Override
    public HashMap<String,Object> getAllDepartment(Department department) {
        HashMap<String,Object> map = new HashMap<>();
        department.setStart((department.getPage()-1)*department.getRows());
        //查询结果集
        List<Department> list=departmentMapper.selectAllDepartment(department);
        //查询总条数
        int total=departmentMapper.selectAllCountBySql();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }


    /**
     * 新增部门信息
     *
     * @param department
     * @return
     */
    @Override
    public int addSelectiveDepartment(Department department) {
        return departmentMapper.insertSelective(department);
    }

    /**
     * 修改部门信息
     *
     * @param department
     * @return
     */
    @Override
    public int editByPrimaryKeySelective(Department department) {
        return departmentMapper.updateByPrimaryKeySelective(department);
    }

    /**
     * 根据部门id删除部门
     * @param removeId
     * @return
     */
    @Override
    public boolean removeByPrimaryKeySelective(String removeId) {
        boolean departmentFlag=true;
        boolean staffFalg=true;
        String[] departmentIds=removeId.split(",");
        for (int i=0;i<departmentIds.length;i++) {
            int index=departmentMapper.deleteByPrimaryKey(Integer.parseInt(departmentIds[i]));
            if(index==0){
                departmentFlag=false;
            }
        }

        return departmentFlag&&staffFalg;
    }

    /**
     * 批量删除部门
     * @param removeId 部门编号IDs
     * @return
     */
    @Override
    public boolean removeBatch(String removeId) {
        String[] departmentIds=removeId.split(",");
        List<Integer> department=new ArrayList<>();
        boolean flag=true;
        for (String departmentId : departmentIds) {
            department.add(Integer.parseInt(departmentId.trim()));
        }
        if(department.size()>0){
             flag= departmentMapper.deleteBatch(department)==0?false:true;
        }
        return flag;
    }

    /**
     * 根据部门编号查询部门信息
     * @param departmentId
     * @return
     */
    @Override
    public Department getOneDepartmentById(int departmentId) {
        return departmentMapper.selectByPrimaryKey(departmentId);
    }

    /**
     * 获取部门信息
     * @return
     */
    @Override
    public List<Department> getAllDepartmentBB() {
        List<Department> departments = departmentMapper.selectAllDepartmentBB();
        List<Department> departmentList=new ArrayList<>();
        for(int i=0;i<departments.size();i++){
            if(departments.get(i).getDepartmentExitsnum()<departments.get(i).getDepartmentTotalnum()){
                Department department=departments.get(i);
                departmentList.add(department);
            }
        }
        return departmentList;
    }

    /**
     * 获取全部的部门信息，不组装
     * @return
     */
    @Override
    public List<Department> getAllDepartmentAA() {
        return departmentMapper.selectAllDepartmentBB();
    }


}
