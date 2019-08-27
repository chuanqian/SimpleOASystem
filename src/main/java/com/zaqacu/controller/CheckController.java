package com.zaqacu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CheckController {

    @RequestMapping(value = "toCheckStaff.check",method = RequestMethod.GET)
    public String toCheckStaff(){
        return "check/checkstaff";
    }

}
