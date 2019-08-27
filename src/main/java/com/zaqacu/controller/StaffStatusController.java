package com.zaqacu.controller;

import com.zaqacu.entity.StaffStatus;
import com.zaqacu.service.StaffStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StaffStatusController {

    @Autowired
    private StaffStatusService staffStatusService;

    @RequestMapping(value = "getAllStaffStatus.status",method = RequestMethod.POST)
    @ResponseBody
    public List<StaffStatus> getAllStaffStatus(){
        return staffStatusService.getAllStaffStatusBB();
    }

}
