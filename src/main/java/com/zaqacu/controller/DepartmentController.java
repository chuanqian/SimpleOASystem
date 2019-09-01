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


    /**
     * 分页获取部门信息
     * @param department
     * @return
     */
    @GetMapping(value = "getAllDepartmentBySql.department")
    @ResponseBody
    public HashMap<String,Object> getAllDepartment(Department department) {
        if(department.getDepartmentName()!=null && department.getDepartmentName()!="") {
            department.setDepartmentName("%" + department.getDepartmentName() + "%");
        }
        return departmentService.getAllDepartment(department);
    }

    /**
     * 部门展示页面
     * @return
     */
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
    @ResponseBody
    public boolean addDepartment(String departmentName, int departmentTotalnum, int departmentExitsnum){
        Department department=new Department();
        department.setDepartmentName(departmentName);
        department.setDepartmentTotalnum(departmentTotalnum);
        department.setDepartmentExitsnum(departmentExitsnum);
        department.setDepartmentLacknum(departmentTotalnum-departmentExitsnum);
        System.out.println("dfsafdfefdsfsfefsf");
        boolean b = departmentService.addSelectiveDepartment(department);
        System.out.println(b);
        return b;

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
     * @param id
     * @return
     */
    @GetMapping(value = "removeDepartment.department")
    @ResponseBody
    public boolean removeDepartmentIds(String id){
        boolean flag = departmentService.removeBatch(id);
        return flag;
    }

    /**
     * 获取封装后的部门信息
     * @return
     */
    @RequestMapping(value="getAllDepartmentBB.department",method = RequestMethod.POST)
    @ResponseBody
    public List<Department> getAllDepartmentBB(){
        return departmentService.getAllDepartmentBB();
    }

    /**
     * 获取全部部门信息
     * @return
     */
    @RequestMapping(value = "getAllDepartmentAA.department")
    @ResponseBody
    public List<Department> getAllDepartmentAA(){
        return departmentService.getAllDepartmentAA();
    }

}
