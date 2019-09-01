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

    @RequestMapping(value = "toBasicMoney.basic")
    public String toBasicMoney(){
        return "pay/basicmoney";
    }

    @RequestMapping(value = "getAllBaiscMoneyBySql.basic")
    @ResponseBody
    public HashMap<String,Object> getAllBaiscMoneyBySql(BasicMoney basicMoney){
        return basicMoneyService.getAllBasicMoneyBySql(basicMoney);
    }

    @RequestMapping(value = "editBasicByBasicMoneyId.basic")
    @ResponseBody
    public boolean editBasicByBasicMoneyId(BasicMoney basicMoney){
        return basicMoneyService.editByPrimaryKeySelective(basicMoney);
    }

    @RequestMapping(value = "removeBasicMoneyByIds.basic")
    @ResponseBody
    public boolean removeBasicMoneyByIds(String id){
        return basicMoneyService.removeBasicMoneyBatch(id);
    }

    @RequestMapping(value = "addBasicMoney.basic")
    @ResponseBody
    public boolean addBasicMoney(BasicMoney basicMoney){
        return basicMoneyService.addSelective(basicMoney);
    }

    @RequestMapping(value = "getAllBasicMoney.basic")
    @ResponseBody
    public List<BasicMoney> getAllBasicMoney(){
        return basicMoneyService.getAllBasicMoney();
    }



}
