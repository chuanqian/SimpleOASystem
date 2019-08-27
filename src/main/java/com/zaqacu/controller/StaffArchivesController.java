package com.zaqacu.controller;

import com.zaqacu.entity.StaffArchives;
import com.zaqacu.service.StaffArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class StaffArchivesController {

    @Autowired
    private StaffArchivesService staffArchivesService;

    @RequestMapping("toStaffArchives.staff")
    public String toStaffArchives(){
        return "staff/archives";
    }


    @RequestMapping("getAllArchivesBySql.staff")
    @ResponseBody
    public HashMap<String,Object> getAllArchivesBySql(StaffArchives staffArchives){
        return staffArchivesService.getAllStaffArchivesBySql(staffArchives);
    }

    @RequestMapping("editArchives.staff")
    @ResponseBody
    public boolean editArchives(StaffArchives staffArchives){
        return staffArchivesService.editStaffArchives(staffArchives);
    }

    @RequestMapping("removeArchives.staff")
    public boolean removeArchives(String id){
        System.out.println(id);
        return staffArchivesService.removeStaffArchives(id);
    }
}
