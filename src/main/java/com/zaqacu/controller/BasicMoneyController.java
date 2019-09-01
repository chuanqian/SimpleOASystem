package com.zaqacu.controller;

import com.zaqacu.entity.BasicMoney;
import com.zaqacu.service.BasicMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class BasicMoneyController {

    @Autowired
    private BasicMoneyService basicMoneyService;

    /**
     * 管理基本工资页面
     * @return
     */
    @RequestMapping(value = "toBasicMoney.basic")
    public String toBasicMoney(){
        return "pay/basicmoney";
    }

    /**
     * 分页查询显示基本工资
     * @param basicMoney
     * @return
     */
    @RequestMapping(value = "getAllBaiscMoneyBySql.basic")
    @ResponseBody
    public HashMap<String,Object> getAllBaiscMoneyBySql(BasicMoney basicMoney){
        return basicMoneyService.getAllBasicMoneyBySql(basicMoney);
    }

    /**
     * 修改基本工资
     * @param basicMoney 基本工资金额
     * @return
     */
    @RequestMapping(value = "editBasicByBasicMoneyId.basic")
    @ResponseBody
    public boolean editBasicByBasicMoneyId(BasicMoney basicMoney){
        return basicMoneyService.editByPrimaryKeySelective(basicMoney);
    }

    /**
     * 通过Id删除基本工资
     * @param id
     * @return
     */
    @RequestMapping(value = "removeBasicMoneyByIds.basic")
    @ResponseBody
    public boolean removeBasicMoneyByIds(String id){
        return basicMoneyService.removeBasicMoneyBatch(id);
    }

    /**
     * 添加基本工资
     * @param basicMoney
     * @return
     */
    @RequestMapping(value = "addBasicMoney.basic")
    @ResponseBody
    public boolean addBasicMoney(BasicMoney basicMoney){
        return basicMoneyService.addSelective(basicMoney);
    }

    /**
     * 获取全部的基本工资List
     * @return
     */
    @RequestMapping(value = "getAllBasicMoney.basic")
    @ResponseBody
    public List<BasicMoney> getAllBasicMoney(){
        return basicMoneyService.getAllBasicMoney();
    }



}
