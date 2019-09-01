package com.zaqacu.controller;

import com.zaqacu.entity.Pay;
import com.zaqacu.entity.Staff;
import com.zaqacu.service.PayService;
import com.zaqacu.service.StaffService;
import com.zaqacu.util.TimeUtls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class PayController {

    @Autowired
    private StaffService staffService;
    @Autowired
    private PayService payService;


    /**
     * 薪酬页面
     * @return
     */
    @RequestMapping(value = "toPay.pay")
    public String toPay(){
        return "pay/pay";
    }

    /**
     * 薪酬记录页面
     * @return
     */
    @RequestMapping("toPayRecord.pay")
    public String toPayRecord(){
        return "pay/payrecord";
    }

    /**
     * 获取展示员工的信息
     * @param xueli 员工学历
     * @param staffNameLike 模糊查询员工姓名
     * @param staff 员工
     * @return
     */
    @RequestMapping(value = "showStaffInfo.pay")
    @ResponseBody()
    public HashMap<String,Object> showStaffInfo(String xueli,String staffNameLike,Staff staff){
        System.out.println("进来");
        if(xueli!=null){
            System.out.println(xueli);
            staff.setStaffXueli(xueli);
        }
        if(staffNameLike!=null){
            System.out.println(staffNameLike);
            staff.setStaffName("%"+staffNameLike+"%");
        }
        return staffService.getAllStaff(staff);
    }

    /**
     * 添加薪酬记录
     * @param staffUid
     * @param StaffName
     * @param payBasicId
     * @param payMertisId
     * @param payTime
     * @return
     */
    @RequestMapping(value = "editStaffPay.pay")
    @ResponseBody()
    public boolean editStaffPay(String staffUid,String StaffName,String payBasicId,String payMertisId,String payTime){
        return payService.addPay(staffUid, StaffName, payBasicId, payMertisId, payTime);
    }

    /**
     * 分页获取全部薪酬记录List
     * @param startTime
     * @param endTime
     * @param staffName
     * @param pay
     * @return
     */
    @RequestMapping(value = "getAllPayRecord.pay")
    @ResponseBody
    public HashMap<String,Object> getAllPayRecord(String startTime,String endTime,String staffName,Pay pay){
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println(staffName);
        if(startTime!=null) {
            pay.setStartTimes(TimeUtls.getTimeParse(startTime));
        }
        if(endTime!=null) {
            pay.setEndTimes(TimeUtls.getTimeParse(endTime));
        }
        if(staffName!=null && staffName != "") {
            pay.setStaffNamePay("%"+staffName+"%");
        }
        return payService.getPayBySql(pay);
    }

    /**
     * 删除信息记录
     * @param id
     * @return
     */
    @RequestMapping(value = "removePayRecord.pay")
    @ResponseBody
    public boolean removePayRecord(String id){
        System.out.println("dfdfdgsd");
        return payService.removePayByIds(id);
    }
}
