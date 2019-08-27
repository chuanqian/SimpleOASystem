package com.zaqacu.controller;

import com.zaqacu.entity.Staff;
import com.zaqacu.service.CheckService;
import com.zaqacu.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class CheckController {

    @Autowired
    private StaffService staffService;
    @Autowired
    private CheckService checkService;

    @RequestMapping(value = "toCheckStaff.check",method = RequestMethod.GET)
    public String toCheckStaff(){
        return "check/checkstaff";
    }

    @RequestMapping(value = "checkStaffShow.check",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String,Object> checkStaffShow(Staff staff){
        return checkService.showCheckStaff(staff);
    }

}
