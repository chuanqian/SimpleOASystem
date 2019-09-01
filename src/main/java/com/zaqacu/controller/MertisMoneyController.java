package com.zaqacu.controller;

import com.zaqacu.entity.MertisMoney;
import com.zaqacu.entitydto.MertisMoneyDto;
import com.zaqacu.service.MertisMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class MertisMoneyController {

    @Autowired
    private MertisMoneyService mertisMoneyService;

    @RequestMapping(value = "toMertisMoney.mertis")
    public String toMertisMoney(){
        return "pay/mertis";
    }

    @RequestMapping(value = "getAllMertisMonteyBySql.mertis", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, Object> getAllMertisMonteyBySql(String percentage,MertisMoney mertisMoney) {
        if(percentage != null && percentage != ""){
            System.out.println("eneter");
            int index=percentage.indexOf("%");
            mertisMoney.setMertisPercentage(Double.parseDouble(percentage.substring(0,index).trim())/100);
        }
        return mertisMoneyService.getMertisMoneyBySql(mertisMoney);
    }

    @RequestMapping(value = "editMertisMoneyByMertisMoneyId.mertis")
    @ResponseBody
    public boolean editMertisMoneyByMertisMoneyId(String mertisMoneyId,String percontage,String mertisMoneyNum) {
        return mertisMoneyService.editMertisMoneyByMertisId(mertisMoneyId,percontage,mertisMoneyNum);
    }

    @RequestMapping(value = "removeMertisMoneyBatch.mertis", method = RequestMethod.GET)
    @ResponseBody
    public boolean removeMertisMoneyBatch(String id) {
        return mertisMoneyService.removeMertisBatch(id);
    }

    @RequestMapping(value = "addOneMertisMoney.mertis")
    @ResponseBody
    public boolean addOneMertisMoney(String percontage,String mertisMoneyNum) {
        return mertisMoneyService.addOneMertisMoney(percontage,mertisMoneyNum);
    }

    @RequestMapping(value = "getAllMertisMoney.mertis")
    @ResponseBody
    public List<MertisMoneyDto> getAllMertisMoney(){
        return mertisMoneyService.getAllMertisMoney();
    }



}
