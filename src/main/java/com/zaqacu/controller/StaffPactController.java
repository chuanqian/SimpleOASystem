package com.zaqacu.controller;

import com.zaqacu.entity.StaffPact;
import com.zaqacu.service.StaffPactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 合同管理
 */
@Controller
public class StaffPactController {

    @Autowired
    private StaffPactService staffPactService;

    /**
     * 合同页面
     * @return
     */
    @RequestMapping("toPactStaff.staff")
    public String toPactStaff() {
        return "staff/pact";
    }

    /**
     * 分页获取合同信息
     * @param staffPact 合同信息
     * @return
     */
    @RequestMapping("getAllStaffPact.staff")
    @ResponseBody
    public HashMap<String, Object> getAllStaffPactBySql(StaffPact staffPact) {
        if (staffPact.getStaffName() != null && staffPact.getStaffName() != "") {
            staffPact.setStaffName("%" + staffPact.getStaffName() + "%");
        }
        return staffPactService.getAllPactBySql(staffPact);
    }

    /**
     * 修改合同
     * @param staffPact
     * @return
     */
    @RequestMapping("editStaffPact.staff")
    public boolean editStaffPact(StaffPact staffPact) {
        return staffPactService.editStaffPactById(staffPact);
    }

}
