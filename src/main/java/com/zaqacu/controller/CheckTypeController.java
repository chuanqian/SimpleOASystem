package com.zaqacu.controller;

import com.zaqacu.entity.CheckType;
import com.zaqacu.service.CheckTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class CheckTypeController {

    @Autowired
    private CheckTypeService checkTypeService;

    @RequestMapping(value = "checktype.check",method = RequestMethod.GET)
    public String checktype(){
        return "check/checktype";
    }

    @RequestMapping(value = "getAllCheckTypeBySql.check",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String,Object> getAllCheckTypeBySql(CheckType checkType){
        return checkTypeService.getAllCheckTypeBySql(checkType);
    }

    @RequestMapping(value = "editCheckType.check",method = RequestMethod.POST)
    @ResponseBody
    public boolean editCheckType(CheckType checkType){
        return checkTypeService.editCheckType(checkType);
    }

    @RequestMapping(value = "addCheckType.check")
    @ResponseBody
    public boolean addCheckType(CheckType checkType){
        return checkTypeService.addCheckType(checkType);
    }

    @RequestMapping(value = "removeCheckType.check")
    @ResponseBody
    public boolean removeCheckType(String id){
        return checkTypeService.removeCheckType(id);
    }

    @RequestMapping(value = "getAllCheckTypeList.check")
    @ResponseBody
    public List<CheckType> getAllCheckTypeList(){
        return checkTypeService.getAllCheckTypeList();
    }

}
