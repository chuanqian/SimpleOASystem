package com.zaqacu.controller;

import com.zaqacu.entity.Staff;
import com.zaqacu.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping(value = "toStaffIndex.staff")
    public String toStaffIndex() {
        return "staff/index";
    }

    @GetMapping(value = "getAllStaff.staff")
    @ResponseBody
    public HashMap<String, Object> getAllStaff(Staff staff) {
        return staffService.getAllStaff(staff);
    }

    @RequestMapping("removeStaff.staff")
    @ResponseBody
    public boolean removeStaff(String id,String positionNames) {
//        System.out.println("zhiwei:"+positionNames);
        return staffService.removeStaff(id,positionNames);
    }

    @RequestMapping("addStaffAndUserLoginAndArchivesAndPact.staff")
    @ResponseBody
    public boolean addStaffAndUserLoginAndArchivesAndPact(String limitName, String userName, String userPassword,
                                                          String staffName, String staffSex, String staffBirth, String staffPhone,
                                                          String staffEmail, String staffXueli, String staffPosition,
                                                          String staffInTime, String staffStatusId, String staffNote, String archivesName,
                                                          String archivesInfo, String archivesNote, String pactCreateTime, String pactEndTime,
                                                          String pactInfo, String pactNote) {
        boolean b = staffService.addStaff(limitName, userName, userPassword,
                staffName, staffSex, staffBirth, staffPhone,
                staffEmail, staffXueli, staffPosition,
                staffInTime, staffStatusId, staffNote, archivesName,
                archivesInfo, archivesNote, pactCreateTime, pactEndTime,
                pactInfo, pactNote);
        System.out.println("dfsadfasdgafdsg");
        System.out.println(b);
        return b;
    }

    @RequestMapping(value = "updateStaff.staff",method = RequestMethod.POST)
    @ResponseBody
    public boolean updateStaff(Staff staff){
        return staffService.editStaff(staff);
    }

}
