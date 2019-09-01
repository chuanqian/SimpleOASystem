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

    /**
     * 员工展示页面
     * @return
     */
    @GetMapping(value = "toStaffIndex.staff")
    public String toStaffIndex() {
        return "staff/index";
    }

    /**
     * 分页获取员工信息页面
     * @param staff
     * @return
     */
    @GetMapping(value = "getAllStaff.staff")
    @ResponseBody
    public HashMap<String, Object> getAllStaff(Staff staff) {
        if(staff.getStaffName()!=null && staff.getStaffName()!=""){
            staff.setStaffName("%"+staff.getStaffName()+"%");
        }
        return staffService.getAllStaff(staff);
    }

    /**
     * 删除员工信息
     * @param id
     * @param positionNames
     * @return
     */
    @RequestMapping("removeStaff.staff")
    @ResponseBody
    public boolean removeStaff(String id,String positionNames) {
//        System.out.println("zhiwei:"+positionNames);
        return staffService.removeStaff(id,positionNames);
    }

    /**
     * 新增员工，账户，合同，档案信息
     * @param userName 员工账户名
     * @param userPassword  员工密码
     * @param staffName 员工姓名
     * @param staffSex 员工性别
     * @param staffBirth 员工出生日期
     * @param staffPhone 员工电话
     * @param staffEmail 员工邮箱
     * @param staffXueli 员工学历
     * @param staffPosition 员工职位
     * @param staffInTime 员工入职时间
     * @param staffStatusId 员工状态ID
     * @param staffNote 员工备注
     * @param archivesName 档案名称
     * @param archivesInfo 档案内容
     * @param archivesNote 档案备注
     * @param pactCreateTime 合同开始时间
     * @param pactEndTime 合同结束时间
     * @param pactInfo 合同内容
     * @param pactNote 合同备注
     * @return
     */
    @RequestMapping("addStaffAndUserLoginAndArchivesAndPact.staff")
    @ResponseBody
    public boolean addStaffAndUserLoginAndArchivesAndPact(String userName, String userPassword,
                                                          String staffName, String staffSex, String staffBirth, String staffPhone,
                                                          String staffEmail, String staffXueli, String staffPosition,
                                                          String staffInTime, String staffStatusId, String staffNote, String archivesName,
                                                          String archivesInfo, String archivesNote, String pactCreateTime, String pactEndTime,
                                                          String pactInfo, String pactNote) {
        boolean b = staffService.addStaff(userName, userPassword,
                staffName, staffSex, staffBirth, staffPhone,
                staffEmail, staffXueli, staffPosition,
                staffInTime, staffStatusId, staffNote, archivesName,
                archivesInfo, archivesNote, pactCreateTime, pactEndTime,
                pactInfo, pactNote);
        System.out.println("dfsadfasdgafdsg");
        System.out.println(b);
        return b;
    }

    /**
     * 修改员工共信息
     * @param staff 员工信息
     * @return
     */
    @RequestMapping(value = "updateStaff.staff",method = RequestMethod.POST)
    @ResponseBody
    public boolean updateStaff(Staff staff){
        return staffService.editStaff(staff);
    }

    /**
     * 添加权限
     * @param staffUid
     * @param staffName
     * @param roleIds
     * @return
     */
    @RequestMapping(value = "toGiveEnable.enable")
    @ResponseBody
    public boolean toGiveEnable(String staffUid,String staffName,String roleIds){
        System.out.println(staffUid);
        System.out.println(staffName);
        System.out.println(roleIds);
        return staffService.toGiveEnable(staffUid,staffName,roleIds);
    }

}
