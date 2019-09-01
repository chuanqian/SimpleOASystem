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

    /**
     * 考勤类型的页面
     * @return
     */
    @RequestMapping(value = "checktype.check",method = RequestMethod.GET)
    public String checktype(){
        return "check/checktype";
    }

    /**
     * 分页查询考勤类型List
     * @param checkType 考勤记录信息
     * @return
     */
    @RequestMapping(value = "getAllCheckTypeBySql.check",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String,Object> getAllCheckTypeBySql(CheckType checkType){
        return checkTypeService.getAllCheckTypeBySql(checkType);
    }

    /**
     * 修改考勤信息
     * @param checkType
     * @return
     */
    @RequestMapping(value = "editCheckType.check",method = RequestMethod.POST)
    @ResponseBody
    public boolean editCheckType(CheckType checkType){
        return checkTypeService.editCheckType(checkType);
    }

    /**
     * 增加考勤类型
     * @param checkType
     * @return
     */
    @RequestMapping(value = "addCheckType.check")
    @ResponseBody
    public boolean addCheckType(CheckType checkType){
        return checkTypeService.addCheckType(checkType);
    }

    /**
     * 删除考勤类型
     * @param id
     * @return
     */
    @RequestMapping(value = "removeCheckType.check")
    @ResponseBody
    public boolean removeCheckType(String id){
        return checkTypeService.removeCheckType(id);
    }

    /**
     * 获取所有的考勤类型信息
     * @return
     */
    @RequestMapping(value = "getAllCheckTypeList.check")
    @ResponseBody
    public List<CheckType> getAllCheckTypeList(){
        return checkTypeService.getAllCheckTypeList();
    }

}
