package com.zaqacu.controller;

import com.zaqacu.entity.Check;
import com.zaqacu.entity.Staff;
import com.zaqacu.entity.UserLogin;
import com.zaqacu.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class CheckController {

    @Autowired
    private CheckService checkService;

    /**
     * 员工考勤页面
     * @return
     */
    @RequestMapping(value = "toCheckStaff.check",method = RequestMethod.GET)
    public String toCheckStaff(){
        return "check/checkstaff";
    }

    /**
     * 展示员工信息和考勤状态页面
     * @param staff
     * @return
     */
    @RequestMapping(value = "checkStaffShow.check",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String,Object> checkStaffShow(Staff staff){
        if(staff.getStaffName()!=null && staff.getStaffName()!=""){
            staff.setStaffName("%"+staff.getStaffName()+"%");
        }
        return checkService.showCheckStaff(staff);
    }

    /**
     * 添加员工的考勤
     * @param staffUid
     * @param staffName
     * @param checkTypeId
     * @param checkTypeMoney
     * @param session
     * @return
     */
    @RequestMapping(value = "editCheckStaffStatusAndCheck.check",method = RequestMethod.POST)
    @ResponseBody
    public boolean editCheckStaffStatusAndCheck(String staffUid, String staffName, String checkTypeId, String checkTypeMoney, HttpSession session){
        //String beiStaffUid, String staffName, String checkTypeId, String checkTypeMoney, String staffUid
//        System.out.println(staffUid);
//        System.out.println(staffName);
//        System.out.println(checkTypeId);
//        System.out.println(checkTypeMoney);
        UserLogin user = (UserLogin) session.getAttribute("user");
        System.out.println(user);
        return checkService.editCheckStaffStatusAndCheck(staffUid, staffName, checkTypeId, checkTypeMoney, user.getStaffUid());
    }

    /**
     * 考勤记录页面
     * @return
     */
    @RequestMapping(value = "toCheckIndex.check",method = RequestMethod.GET)
    public String toCheckIndex(){
        return "check/checkIndex";
    }

    /**
     * 分页查询考勤页面
     * @param check
     * @return
     */
    @RequestMapping(value = "showCheckRecord.check",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String,Object> showCheckRecord(Check check){
        if(check.getStaffName()!=null && check.getStaffName()!=""){
            check.setStaffName("%"+check.getStaffName()+"%");
        }
        return checkService.showCheckRecord(check);
    }

    /**
     * 删除考勤记录
     * @param id
     * @return
     */
    @RequestMapping(value = "removeCheckRecord.check",method = RequestMethod.GET)
    @ResponseBody
    public boolean removeCheckRecord(String id){
        return checkService.removeCheckRecord(id);
    }

}
