package com.zaqacu.controller;

import com.zaqacu.entity.Personnel;
import com.zaqacu.entitydto.PersonnelDto;
import com.zaqacu.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class PersonnelContrller {

    @Autowired
    private PersonnelService service;

    @RequestMapping(value = "toPersonnelstaff.personnel")
    public String toPersonnelStaff(){
        return "personnel/personnelstaff";
    }

    @RequestMapping(value = "getAllStaffByPersonnel.personnel")
    @ResponseBody
    public List<PersonnelDto> getAllStaffByPersonnel() {
        return service.getAllStaffAndPosition();
    }

    @RequestMapping(value = "editPersonnel.personnel",method = RequestMethod.POST)
    public boolean editPersonnel(String personnelStaffUid,String sName,String positionName,String personnelNewPositionId,String personnelCause){

//        System.out.println(personnelStaffUid);
//        System.out.println(sName);
//        System.out.println(positionName);
//        System.out.println(personnelCause);
//        System.out.println(personnelNewPositionId);

        return service.editPersonnelByPosition(personnelStaffUid,sName, positionName,personnelNewPositionId,personnelCause);
    }

    @RequestMapping(value = "toPersonnelIndex.personnel")
    public String toPersonnelIndex(){
        return "personnel/personnelIndex";
    }

    @RequestMapping(value = "getAllPersonnelBySql.personsition",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String,Object> getAllPersonnelBySql(Personnel personnel){
        return service.getAllPersonnelBySql(personnel);
    }

    @RequestMapping(value = "removePersonnel.personnel",method = RequestMethod.GET)
    @ResponseBody
    public boolean removePersonnel(String id){
        return service.removePersonnel(id);
    }

}
