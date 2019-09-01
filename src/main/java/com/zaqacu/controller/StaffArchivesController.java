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

    /**
     * 档案显示页面
     * @return
     */
    @RequestMapping("toStaffArchives.staff")
    public String toStaffArchives(){
        return "staff/archives";
    }


    /**
     * 分页获取合档案信息
     * @param staffArchives
     * @return
     */
    @RequestMapping("getAllArchivesBySql.staff")
    @ResponseBody
    public HashMap<String,Object> getAllArchivesBySql(StaffArchives staffArchives){
        if (staffArchives.getArchivesName() != null && staffArchives.getArchivesName() != ""){
            staffArchives.setArchivesName("%"+staffArchives.getArchivesName()+"%");
        }
        return staffArchivesService.getAllStaffArchivesBySql(staffArchives);
    }

    /**
     * 修改档案信息
     * @param staffArchives
     * @return
     */
    @RequestMapping("editArchives.staff")
    @ResponseBody
    public boolean editArchives(StaffArchives staffArchives){
        return staffArchivesService.editStaffArchives(staffArchives);
    }

    /**
     * 删除档案信息
     * @param id
     * @return
     */
    @RequestMapping("removeArchives.staff")
    public boolean removeArchives(String id){
        System.out.println(id);
        return staffArchivesService.removeStaffArchives(id);
    }
}
