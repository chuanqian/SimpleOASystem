package com.zaqacu.controller;

import com.zaqacu.entity.Department;
import com.zaqacu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @GetMapping(value = "getAllDepartmentBySql.department")
    @ResponseBody
    public HashMap<String,Object> getAllDepartment(Department department) {
        return departmentService.getAllDepartment(department);
    }
    @GetMapping(value = "toDepartment.department")
    public String toDepartment(){
        return "department/department";
    }

    /**
     * 新增部门
     * @param departmentName
     * @param departmentTotalnum
     * @param departmentExitsnum
     * @return
     */
    @PostMapping(value = "addDepartment.department")
    public boolean addDepartment(String departmentName, int departmentTotalnum, int departmentExitsnum){
        Department department=new Department();
        department.setDepartmentName(departmentName);
        department.setDepartmentTotalnum(departmentTotalnum);
        department.setDepartmentExitsnum(departmentExitsnum);
        department.setDepartmentLacknum(departmentTotalnum-departmentExitsnum);
        int flag=departmentService.addSelectiveDepartment(department);
        if (flag!=0){
            return true;
        }else{

            return false;
        }
    }

    /**
     * 修改部门
     * @param department
     * @return
     */
    @PostMapping(value = "editDepartment.department")
    @ResponseBody
    public boolean editDepartment(Department department){
        department.setDepartmentLacknum(department.getDepartmentTotalnum()-department.getDepartmentExitsnum());
        int flag = departmentService.editByPrimaryKeySelective(department);
        if(flag!=0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 删除部门
     * @param removeIds
     * @return
     */
    @GetMapping(value = "removeDepartment.department")
    @ResponseBody
    public boolean removeDepartmentIds(String removeIds){
        boolean flag = departmentService.removeBatch(removeIds);
        return flag;
    }


    @RequestMapping(value="getAllDepartmentBB.department",method = RequestMethod.POST)
    @ResponseBody
    public List<Department> getAllDepartmentBB(){
        return departmentService.getAllDepartmentBB();
    }

}
