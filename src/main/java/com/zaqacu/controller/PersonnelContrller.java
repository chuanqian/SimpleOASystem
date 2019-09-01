package com.zaqacu.controller;

import com.zaqacu.entity.Personnel;
import com.zaqacu.entity.Staff;
import com.zaqacu.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class PersonnelContrller {

    @Autowired
    private PersonnelService service;

    /**
     * 人事员工页面
     * @return
     */
    @RequestMapping(value = "toPersonnelstaff.personnel")
    public String toPersonnelStaff(){
        return "personnel/personnelstaff";
    }

    /**
     * 分页获取员工显示信息
     * @param staff
     * @return
     */
    @RequestMapping(value = "getAllStaffByPersonnel.personnel")
    @ResponseBody
    public HashMap<String, Object> getAllStaffByPersonnel(Staff staff) {
        System.out.println(staff.getRows());
//        System.out.println("dfdfsdfsdfdsf");
        System.out.println(staff);
//        System.out.println("dfsdfsdfasdfasdfasd");
        if(staff.getStaffName()!=null && staff.getStaffName()!="") {
            staff.setStaffName("%" + staff.getStaffName() + "%");
        }
        return service.getAllStaffAndPosition(staff);
    }

    /**
     * 修改新增记录
     * @param personnelStaffUid
     * @param sName
     * @param positionName
     * @param personnelNewPositionId
     * @param personnelCause
     * @return
     */
    @RequestMapping(value = "editPersonnel.personnel",method = RequestMethod.POST)
    public boolean editPersonnel(String personnelStaffUid,String sName,String positionName,String personnelNewPositionId,String personnelCause){

//        System.out.println(personnelStaffUid);
//        System.out.println(sName);
//        System.out.println(positionName);
//        System.out.println(personnelCause);
//        System.out.println(personnelNewPositionId);

        return service.editPersonnelByPosition(personnelStaffUid,sName, positionName,personnelNewPositionId,personnelCause);
    }

    /**
     * 人事调动记录的页面
     * @return
     */
    @RequestMapping(value = "toPersonnelIndex.personnel")
    public String toPersonnelIndex(){
        return "personnel/personnelIndex";
    }

    /**
     * 分页获取调动记录的页面
     * @param personnel
     * @return
     */
    @RequestMapping(value = "getAllPersonnelBySql.personsition",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String,Object> getAllPersonnelBySql(Personnel personnel){
        if(personnel.getStaffName()!=null){
            personnel.setStaffName("%"+personnel.getStaffName()+"%");
        }
        System.out.println(personnel.getStartTime());
        System.out.println(personnel.getEndTime());
        return service.getAllPersonnelBySql(personnel);
    }

    /**
     * 删除调动记录
     * @param id
     * @return
     */
    @RequestMapping(value = "removePersonnel.personnel",method = RequestMethod.GET)
    @ResponseBody
    public boolean removePersonnel(String id){
        return service.removePersonnel(id);
    }

}
